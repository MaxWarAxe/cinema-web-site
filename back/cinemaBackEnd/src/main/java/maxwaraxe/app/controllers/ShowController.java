package maxwaraxe.app.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import maxwaraxe.app.dao.ShowDAO;
import maxwaraxe.app.models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Component
@RequestMapping(value = "/shows", produces = "application/json;charset=UTF-8")
public class ShowController {

    private ShowDAO showDAO;
    private ObjectMapper objectMapper;

    @GetMapping(value = "{date}")
    public String getShowByDate(@PathVariable("date")@DateTimeFormat(pattern="yyyy-MM-dd") Date date) throws JsonProcessingException {
        List<Show> showList = showDAO.getShowsByDate(date);
        return objectMapper.writeValueAsString(showList);
    }

    @GetMapping(value="/id/{id}")
    public String getShowById(@PathVariable("id")int id) throws JsonProcessingException{
        Show show = showDAO.getShowsById(id);
        return objectMapper.writeValueAsString(show);
    }

    @GetMapping()
    public String getShows() throws JsonProcessingException {
        return objectMapper.writeValueAsString(showDAO.getAllShows());
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Autowired
    public void setShowDAO(ShowDAO showDAO) {
        this.showDAO = showDAO;
    }
}
