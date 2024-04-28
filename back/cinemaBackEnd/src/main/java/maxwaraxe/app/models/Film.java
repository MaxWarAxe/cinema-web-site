package maxwaraxe.app.models;

import java.util.Date;

public class Film {
    private int id;
    private String name;
    private Date worldPremiereDate;
    private int duration;
    private int ageRating;
    private String imagePath;

    public Film() {}

    public Film(int id, String name, Date worldPremiereDate, int duration, int ageRating, String imagePath) {
        this.id = id;
        this.name = name;
        this.worldPremiereDate = worldPremiereDate;
        this.duration = duration;
        this.ageRating = ageRating;
        this.imagePath = imagePath;
    }

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
