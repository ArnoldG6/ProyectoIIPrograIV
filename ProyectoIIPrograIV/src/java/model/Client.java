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
        this.name = username;
        this.id = id.toUpperCase();
        this.email = email;
        this.telNum = telNum;
        this.pass = pass;
        this.role = "CLI";
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Username:").append(getName()).append(".\n");
        s.append("ID:").append(getId()).append(".\n");
        s.append("Email: ").append(getEmail()).append(".\n");
        s.append("Password:").append(getPass()).append(".\n");
        s.append("Type:").append(getRole()).append(".\n");
        return s.toString();
    }

    public Client() {
        this("", "", "", "", "");
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
}
