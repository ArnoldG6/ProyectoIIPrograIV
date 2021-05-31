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
    private final static String SUB_STATUS = "OFERTA";

    public Room() {
        ticketOffice = new HashMap<>();
    }

}
