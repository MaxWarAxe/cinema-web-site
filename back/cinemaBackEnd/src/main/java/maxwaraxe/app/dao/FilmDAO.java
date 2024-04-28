package maxwaraxe.app.dao;

import maxwaraxe.app.connections.PostgresConnection;
import maxwaraxe.app.mappers.FilmMapper;
import maxwaraxe.app.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.List;

@Component
public class FilmDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Film> getAllFilms(){
        return jdbcTemplate.query("SELECT * FROM film",new FilmMapper());
    }

    public Film getFilmById(int id){
        return jdbcTemplate.query("SELECT * FROM film WHERE id=?",new Object[]{id},new FilmMapper()).stream().findAny().orElse(null);
    }
}
