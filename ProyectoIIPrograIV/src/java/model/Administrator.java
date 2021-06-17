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
public class Administrator extends User {

    public Administrator(String username, String id, String email, String telNum, String pass) {
        this.name = username;
        this.id = id.toUpperCase();
        this.email = email;
        this.telNum = telNum;
        this.pass = pass;
        this.role = "ADM";
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

    public Administrator() {
        this("", "", "", "", "");
    }

}
