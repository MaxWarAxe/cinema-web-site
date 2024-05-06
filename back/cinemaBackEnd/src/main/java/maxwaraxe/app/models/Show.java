package maxwaraxe.app.models;

import java.sql.Date;

public class Show {
    private int id;
    private int hallNumber;
    private int filmId;
    private float basePrice;
    private int duration;
    private Date date;

    public Show(int id, int hallNumber, int filmId, int basePrice, int duration, Date date) {
        this.id = id;
        this.hallNumber = hallNumber;
        this.filmId = filmId;
        this.basePrice = basePrice;
        this.duration = duration;
        this.date = date;
    }
    public Show(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
