package maxwaraxe.app.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import maxwaraxe.app.dao.TicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping(value = "/tickets",produces = "application/json;charset=UTF-8")
public class TicketController {

    @Autowired
    private TicketDAO ticketDAO;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "{id}")
    public String getTicketsByShowId(@PathVariable(value = "id") int id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(ticketDAO.getTicketsByShowId(id));
    }
}
