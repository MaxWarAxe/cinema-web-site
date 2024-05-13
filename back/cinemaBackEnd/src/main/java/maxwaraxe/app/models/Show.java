package maxwaraxe.app.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class Show {
    private int id;
    private int hallNumber;
    private String hallType;
    private int filmId;
    private float basePrice;
    private int duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Timestamp date;

    public Show(int id, int hallNumber, String hallType, int filmId, int basePrice, int duration, Timestamp date) {
        this.id = id;
        this.hallNumber = hallNumber;
        this.hallType = hallType;
        this.filmId = filmId;
        this.basePrice = basePrice;
        this.duration = duration;
        this.date = date;
    }
    public Show(){}


    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
