package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Tickets {

    private HashMap<String, Projections> tickets;

    Tickets() {
        this.tickets = new HashMap<>();
    }

    public HashMap<String, Projections> getTickets() {
        return tickets;
    }

    public void setTickets(HashMap<String, Projections> tickets) {
        this.tickets = tickets;
    }

}
