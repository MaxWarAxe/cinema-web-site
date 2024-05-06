package maxwaraxe.app.dao;


import maxwaraxe.app.mappers.ShowMapper;
import maxwaraxe.app.models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ShowDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Show> getShowsByDate(Date date){
        return jdbcTemplate.query(
                "SELECT *\n" +
                "FROM show s\n" +
                "WHERE s.show_datetime >= ? AND s.show_datetime < (?::date + '1 day'::interval)", new Object[]{date,date},new ShowMapper());
    }
    public List<Show> getAllShows(){
        return jdbcTemplate.query(
                "SELECT * FROM show"
                ,new ShowMapper());
    }
}
