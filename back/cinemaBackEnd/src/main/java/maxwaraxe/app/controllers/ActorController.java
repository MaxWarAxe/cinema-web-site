package maxwaraxe.app.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import maxwaraxe.app.dao.ActorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RequestMapping(value = "/actors",produces = "application/json;charset=UTF-8")
@RestController
@Setter
@Getter
public class ActorController {
    @Autowired
    ActorDAO actorDAO;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping()
    public String getAllActors() throws JsonProcessingException {
        return objectMapper.writeValueAsString(actorDAO.getAllActors());
    }
}
