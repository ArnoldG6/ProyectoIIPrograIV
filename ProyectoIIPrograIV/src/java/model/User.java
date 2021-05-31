package model;

import java.security.SecureRandom;

public class User implements java.io.Serializable {

    String username;
    String id;
    String email;
    String telNum;
    String pass;
    int type;

    public User() {
        username = "";
        id = "";
        email = "";
        telNum = "";
        pass = "";
        type = 0;

    }

    public boolean valPass(String pass) {
        return (this.pass).equals(pass);
    }

    public int getType() {
        return type;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNum() {
        return telNum;
    }

    public void telNum(String telNum) {
        this.telNum = telNum;
    }

    // Method to generate a random alphanumeric password of a specific length
    public static String generateRandomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        String pass1 = "";
        for (int i = 0; i < len; i++) {
            pass1 += chars.charAt(random.nextInt(chars.length()));
        }
        return pass1;

    }

}
