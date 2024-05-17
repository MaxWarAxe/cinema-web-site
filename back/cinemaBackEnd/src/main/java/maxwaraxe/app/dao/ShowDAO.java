package maxwaraxe.app.dao;


import maxwaraxe.app.mappers.ShowMapper;
import maxwaraxe.app.models.Show;
import maxwaraxe.app.models.ShowShort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
                "SELECT s.show_id,s.hall_number,s.film_id,s.show_base_price,s.show_duration,s.show_datetime,h.hall_type\n" +
                "FROM show s LEFT JOIN hall h ON s.hall_number = h.hall_number\n" +
                "WHERE s.show_datetime >= ? AND s.show_datetime < (?::date + '1 day'::interval)", new Object[]{date,date},new ShowMapper());
    }

    public Show getShowsById(int id){
        return jdbcTemplate.query(
                "SELECT s.show_id,s.hall_number,s.film_id,s.show_base_price,s.show_duration,s.show_datetime,h.hall_type\n" +
                        "FROM show s LEFT JOIN hall h ON s.hall_number = h.hall_number\n"+
                       "WHERE s.show_id = ?", new Object[]{id},new ShowMapper()).stream().findAny().orElse(null);
    }

    public List<ShowShort> getAllShows(){
        return jdbcTemplate.query(
                "SELECT * FROM show"
                ,new BeanPropertyRowMapper<>(ShowShort.class));
    }
}
