package model;

import java.security.SecureRandom;

public class User {
    String name;
    String id;
    String email;
    String telNum;
    String pass;
    String role;
    public User(String name,String id,String email,String telNum,String pass, String role) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.telNum = telNum;
        this.pass = pass;
        this.role = role;

    }
    public User() {
        this("","","","","","");
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
    public boolean correctPswd(String pass){
        return pass.equals(this.getPass());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
