/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Room {

    private String id;
    private HashMap<String, Integer> ticketOffice;

    public Room(String id) {
        this.id=id;
        this.ticketOffice = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = id;
    }

    public HashMap<String, Integer> getTicketOffice() {
        return ticketOffice;
    }

    public void setTicketOffice(HashMap<String, Integer> ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

}
