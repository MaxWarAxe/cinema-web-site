package maxwaraxe.app.dao;

import maxwaraxe.app.mappers.DirectorMapper;
import maxwaraxe.app.models.Actor;
import maxwaraxe.app.models.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DirectorDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Director> getAllDirectors(){
        return jdbcTemplate.query("SELECT *\n" +
                "FROM director",new DirectorMapper());
    }
}
