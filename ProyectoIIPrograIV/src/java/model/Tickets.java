package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Tickets {

    private String number;
    private HashMap<String, Projections> tickets;

    public Tickets(String num) {
        this.number = num;
        this.tickets = new HashMap<>();
    }

    public HashMap<String, Projections> getTickets() {
        return tickets;
    }

    public void setTickets(HashMap<String, Projections> tickets) {
        this.tickets = tickets;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
