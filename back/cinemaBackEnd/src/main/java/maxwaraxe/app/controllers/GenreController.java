package maxwaraxe.app.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import maxwaraxe.app.dao.GenreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@Setter
@Component
@RestController
@RequestMapping(value = "/genres",produces = "application/json;charset=UTF-8")
public class GenreController {
    @Autowired
    private GenreDAO genreDAO;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping()
    public String getAllGenres() throws JsonProcessingException {
       return objectMapper.writeValueAsString(genreDAO.getAllGenres());
    }
}
