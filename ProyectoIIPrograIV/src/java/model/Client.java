/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author victo
 */
public class Client extends User {
    
    private int cardNumber;

    public Client(String username, String id, String email, String telNum, String pass) {
        this.cardNumber = 0;
        this.username = username;
        this.id = id.toUpperCase();
        this.email = email;
        this.telNum = telNum;
        this.pass = pass;
        this.type = 3;
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Username:").append(username).append(".\n");
        s.append("ID:").append(id).append(".\n");
        s.append("Email: ").append(email).append(".\n");
        s.append("Password:").append(pass).append(".\n");
        s.append("Type:").append(String.valueOf(type)).append(".\n");
        return s.toString();
    }
    public Client() {
        this("", "", "", "", "");
    }
}
