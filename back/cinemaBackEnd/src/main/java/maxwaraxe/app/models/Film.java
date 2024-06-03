package maxwaraxe.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    private int id;
    private String name;
    private Date worldPremiereDate;
    private int duration;
    private int ageRating;
    private String imagePath;
    private String description;
    private List<String> genres = new ArrayList<String>();
    private List<String> directors = new ArrayList<String>();
    private List<String> actors = new ArrayList<String>();
    private List<String> countries = new ArrayList<String>();

}
