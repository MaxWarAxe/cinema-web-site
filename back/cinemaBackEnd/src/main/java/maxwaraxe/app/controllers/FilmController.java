package maxwaraxe.app.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import maxwaraxe.app.dao.FilmDAO;
import maxwaraxe.app.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
