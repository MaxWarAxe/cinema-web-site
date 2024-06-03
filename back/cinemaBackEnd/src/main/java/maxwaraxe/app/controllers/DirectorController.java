package maxwaraxe.app.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import maxwaraxe.app.dao.DirectorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping(value = "/directors",produces = "application/json;charset=UTF-8")
@Setter
@Getter
public class DirectorController {
    @Autowired
    DirectorDAO directorDAO;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping()
    public String getAllDirectors() throws JsonProcessingException {
        return objectMapper.writeValueAsString(directorDAO.getAllDirectors());
    }
}
