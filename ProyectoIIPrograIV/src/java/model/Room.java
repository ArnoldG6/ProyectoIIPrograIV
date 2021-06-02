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

    private String name;
    private HashMap<String, Integer> ticketOffice;

    public Room(String nam) {
        this.name=nam;
        this.ticketOffice = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Integer> getTicketOffice() {
        return ticketOffice;
    }

    public void setTicketOffice(HashMap<String, Integer> ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

}
