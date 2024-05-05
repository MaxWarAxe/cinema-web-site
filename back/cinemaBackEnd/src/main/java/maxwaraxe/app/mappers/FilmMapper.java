package maxwaraxe.app.mappers;

import maxwaraxe.app.models.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        film.setDescription(rs.getString("film_description"));
        film.setCountries(Arrays.asList((String[])rs.getArray("country_list").getArray()));
        film.setDirectors(Arrays.asList((String[])rs.getArray("director_list").getArray()));
        film.setActors(Arrays.asList((String[])rs.getArray("actor_list").getArray()));
        return film;
    }
}
