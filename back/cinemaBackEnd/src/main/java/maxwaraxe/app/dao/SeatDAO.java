package maxwaraxe.app.dao;

import lombok.Setter;
import maxwaraxe.app.mappers.SeatMapper;
import maxwaraxe.app.models.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Setter
@Component
public class SeatDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Seat> getSeatsByHallNumber(int hallNumber){
       return jdbcTemplate.query("SELECT st.seat_id,h.hall_number,st.seat_coefficient,st.seat_number,st.seat_row_number\n" +
               "FROM hall h LEFT JOIN seat st ON h.hall_number = st.hall_number\n" +
               "WHERE h.hall_number = ?",new Object[]{hallNumber},new SeatMapper());
    }
}
