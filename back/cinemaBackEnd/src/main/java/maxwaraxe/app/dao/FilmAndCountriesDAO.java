package maxwaraxe.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmAndCountriesDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String insertAllCountriesToFilm(List<String> countrys,int filmId){
        for(String country : countrys ){
            jdbcTemplate.update("INSERT INTO location_of_studio (film_id,country_name) VALUES (?,?)",new Object[]{filmId,country});
        }
        return "ok";
    }
}
