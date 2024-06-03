package maxwaraxe.app.dao;

import lombok.Getter;
import lombok.Setter;
import maxwaraxe.app.mappers.ActorMapper;
import maxwaraxe.app.models.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@Getter
public class ActorDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Actor> getAllActors(){
        return jdbcTemplate.query("SELECT *\n" +
                "FROM actor",new ActorMapper());
    }
}
