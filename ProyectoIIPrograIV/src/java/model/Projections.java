package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Projections {

    private String date;
    private String hour;
    private HashMap<String, Room> rooms;
    private HashMap<String, Room> movies;

    Projections(String dat, String hor) {
        this.date = dat;
        this.hour = hor;
        this.rooms = new HashMap<>();
        this.movies = new HashMap<>();
    }

    Projections() {
        this("", "");
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }

    public HashMap<String, Room> getMovies() {
        return movies;
    }

    public void setMovies(HashMap<String, Room> movies) {
        this.movies = movies;
    }

}
