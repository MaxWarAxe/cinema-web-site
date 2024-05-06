package maxwaraxe.app.dao;
import maxwaraxe.app.mappers.FilmMapper;
import maxwaraxe.app.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("classpath:config.properties")
public class FilmDAO {

    private final JdbcTemplate jdbcTemplate;
    private ResourceLoader resourceLoader;

    @Value("${images.path}")
    private String imagesPath;

    @Autowired
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @Autowired
    public FilmDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Film> getAllFilms(){
        return jdbcTemplate.query(
                "SELECT f.film_id,\n" +
                "f.film_name,\n" +
                "f.film_world_premiere_date,\n" +
                "f.film_duration,\n" +
                "f.film_description,\n" +
                "f.film_age_rating,\n" +
                "f.film_image_path,\n" +
                "array_agg(DISTINCT g.genre_name) as genre_list,\n" +
                "array_agg(DISTINCT l.country_name) as country_list,\n" +
                "array_agg(DISTINCT (SELECT director.director_name_and_surname FROM director WHERE d.director_id = director.director_id)) as director_list,\n" +
                "array_agg(DISTINCT (SELECT actor.actor_name_and_surname FROM actor WHERE a.actor_id = actor.actor_id)) as actor_list\n" +
                "\n" +
                "FROM film f LEFT JOIN  contained g ON f.film_id = g.film_id\n" +
                "LEFT JOIN location_of_studio l ON f.film_id = l.film_id\n" +
                "LEFT JOIN direct d ON f.film_id = d.film_id\n" +
                "LEFT JOIN acting a ON f.film_id = a.film_id\n" +
                "GROUP BY f.film_id",new FilmMapper());
    }

    public Film getFilmById(Long id){
        return jdbcTemplate.query(
                "SELECT f.film_id,\n" +
                "f.film_name,\n" +
                "f.film_world_premiere_date,\n" +
                "f.film_duration,\n" +
                "f.film_description,\n" +
                "f.film_age_rating,\n" +
                "f.film_image_path,\n" +
                "array_agg(DISTINCT g.genre_name) as genre_list,\n" +
                "array_agg(DISTINCT l.country_name) as country_list,\n" +
                "array_agg(DISTINCT (SELECT director.director_name_and_surname FROM director WHERE d.director_id = director.director_id)) as director_list,\n" +
                "array_agg(DISTINCT (SELECT actor.actor_name_and_surname FROM actor WHERE a.actor_id = actor.actor_id)) as actor_list\n" +
                "\n" +
                "FROM film f LEFT JOIN  contained g ON f.film_id = g.film_id\n" +
                "LEFT JOIN location_of_studio l ON f.film_id = l.film_id\n" +
                "LEFT JOIN direct d ON f.film_id = d.film_id\n" +
                "LEFT JOIN acting a ON f.film_id = a.film_id\n" +
                "WHERE f.film_id = ?\n"+
                "GROUP BY f.film_id",new Object[]{id},new FilmMapper()).stream().findAny().orElse(null);
    }

    public Resource getImageByPath(String path){
        System.out.println(imagesPath + "/" + path);
        return resourceLoader.getResource(imagesPath + "/" + path);
    }
}
