package maxwaraxe.app.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Film {
    private int id;
    private String name;
    private Date worldPremiereDate;
    private int duration;
    private int ageRating;
    private String imagePath;
    private List<String> genres = new ArrayList<String>();
    private List<String> directors = new ArrayList<String>();
    private List<String> actors = new ArrayList<String>();
    private List<String> countries = new ArrayList<String>();

    public Film(int id, String name, Date worldPremiereDate, int duration, int ageRating, String imagePath, List<String> genres, List<String> directors, List<String> actors, List<String> countries, String description) {
        this.id = id;
        this.name = name;
        this.worldPremiereDate = worldPremiereDate;
        this.duration = duration;
        this.ageRating = ageRating;
        this.imagePath = imagePath;
        this.genres = genres;
        this.directors = directors;
        this.actors = actors;
        this.countries = countries;
        this.description = description;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public Film() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getWorldPremiereDate() {
        return worldPremiereDate;
    }

    public void setWorldPremiereDate(Date worldPremiereDate) {
        this.worldPremiereDate = worldPremiereDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
