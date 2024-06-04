package maxwaraxe.app.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import maxwaraxe.app.dao.FilmDAO;
import maxwaraxe.app.models.Film;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@Component
@RequestMapping(value = "/films", produces = "application/json;charset=UTF-8")
public class FilmController {

    private FilmDAO filmDAO;
    private ObjectMapper objectMapper;

    @Autowired
    public void setFilmDAO(FilmDAO filmDAO){
        this.filmDAO = filmDAO;
    }
    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @GetMapping()
    public String getAllFilms() throws JsonProcessingException {
        List<Film> listOfFilms = filmDAO.getAllFilms();
        return objectMapper.writeValueAsString(listOfFilms);
    }

    @PostMapping("/new")
    public String createNewFilm(@RequestBody Film newFilm){
        System.out.println(newFilm.toString());
        filmDAO.createNewFilm(newFilm);
        return "1";
    }

    @GetMapping("{id}")
    public String getFilmById(@PathVariable("id") Long id) throws JsonProcessingException {
        Film film = filmDAO.getFilmById(id);
        return objectMapper.writeValueAsString(film);
    }

    @GetMapping(value = "/image",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Resource getImageByPath(@RequestParam(name = "path") String path){
        return this.filmDAO.getImageByPath(path);
    }

    @PostMapping(value= "/image/new")
    public String addImage(@RequestPart(value = "image") MultipartFile multipartFile) throws IOException {
        filmDAO.addImage(multipartFile);
        return "ok";
    }
}
