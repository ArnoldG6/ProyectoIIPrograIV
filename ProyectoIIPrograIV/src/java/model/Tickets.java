package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Tickets {

    private String id;
    private ticketOffice ticketOffice1;
    private Room room;
    private Projections pro;
    private Movie mov;
    
    public Tickets(String num, ticketOffice ticketOffice2, Room room1, Projections project, Movie movie1) {
        this.id = num;
        this.ticketOffice1=ticketOffice2;
        this.room=room1;
        this.pro=project;
        this.mov=movie1;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ticketOffice getTicketOffice1() {
        return ticketOffice1;
    }

    public void setTicketOffice1(ticketOffice ticketOffice1) {
        this.ticketOffice1 = ticketOffice1;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Projections getPro() {
        return pro;
    }

    public void setPro(Projections pro) {
        this.pro = pro;
    }

    public Movie getMov() {
        return mov;
    }

    public void setMov(Movie mov) {
        this.mov = mov;
    }
    
}
