package maxwaraxe.app.mappers;

import maxwaraxe.app.models.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {

    @Override
    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
        Film film = new Film();

        film.setId(rs.getInt("film_id"));
        film.setName(rs.getString("film_name"));
        film.setAgeRating(rs.getInt("film_age_rating"));
        film.setDuration(rs.getInt("film_duration"));
        film.setWorldPremiereDate(rs.getDate("film_world_premiere_date"));
        film.setImagePath(rs.getString("film_image_path"));
        return film;
    }
}
