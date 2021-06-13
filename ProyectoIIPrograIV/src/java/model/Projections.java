package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Projections {

    private String number;
    private String date;
    private String hour;
    private Room rooms;
    private Movie mov;

    public Projections(String num, String dat, String hor, Room room1, Movie mov1) {
        this.number = num;
        this.date = dat;
        this.hour = hor;
        this.rooms = room1;
        this.mov = mov1;
    }

    public Projections() {
        this("", "", "", null, null);
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Room getRooms() {
        return rooms;
    }

    public void setRooms(Room rooms) {
        this.rooms = rooms;
    }

    public Movie getMov() {
        return mov;
    }

    public void setMov(Movie mov) {
        this.mov = mov;
    }

}
