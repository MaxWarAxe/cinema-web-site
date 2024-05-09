package maxwaraxe.app.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import maxwaraxe.app.dao.SeatDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Setter
@RestController
@Component
@RequestMapping(value="/seats",produces = "application/json;charset=UTF-8")
public class SeatController {

    @Autowired
    SeatDAO seatDAO;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "{id}")
    public String getSeatsByHallNumber(@PathVariable(value = "id") int hallNumber) throws JsonProcessingException {
        return objectMapper.writeValueAsString(seatDAO.getSeatsByHallNumber(hallNumber));
    }
}
