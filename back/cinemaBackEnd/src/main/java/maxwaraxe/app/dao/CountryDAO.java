package maxwaraxe.app.dao;

import maxwaraxe.app.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Country> getAllCountries(){
        return jdbcTemplate.query("SELECT* FROM country",new BeanPropertyRowMapper<>(Country.class));
    }
}
