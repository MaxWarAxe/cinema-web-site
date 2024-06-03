package maxwaraxe.app.dao;

import maxwaraxe.app.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Genre> getAllGenres(){
        return jdbcTemplate.query("SELECT* FROM genre",new BeanPropertyRowMapper<>(Genre.class));
    }
}
