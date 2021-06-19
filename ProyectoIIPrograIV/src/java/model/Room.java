package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Room {

    private String id;
    private HashMap<String, ticketOffice> ticketOffices;

    public Room(String id) {
        this.id = id;
        this.ticketOffices = new HashMap<>();
    }
    
    public Room(){
        this("wea");
    }

    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = id;
    }

    public HashMap<String, ticketOffice> getTicketOffices() {
        return ticketOffices;
    }

    public void setTicketOffices(HashMap<String, ticketOffice> ticketOffice) {
        this.ticketOffices = ticketOffice;
    }

}
