package model;

import java.util.HashMap;

/**
 *
 * @author victo
 */
public class Cinema {

    private HashMap<String, Movie> movies;
    private HashMap<String, Movie> billdBoards;
    private HashMap<String, Projections> projections;
    private HashMap<String, Room> rooms;
    private HashMap<String, Administrator> admins;
    
    private HashMap<String, Client> client;

    public Cinema() {
        movies = new HashMap<>();
        billdBoards = new HashMap<>();
        projections = new HashMap<>();
        rooms = new HashMap<>();
        admins = new HashMap<>();
        client = new HashMap<>();
    }
    
    
    
    

    public HashMap<String, Movie> getMovies() {
        return movies;
    }

    public void setMovies(HashMap<String, Movie> movies) {
        this.movies = movies;
    }

    public HashMap<String, Movie> getBilldBoards() {
        return billdBoards;
    }

    public void setBilldBoards(HashMap<String, Movie> billdBoards) {
        this.billdBoards = billdBoards;
    }

    public HashMap<String, Projections> getProjections() {
        return projections;
    }

    public void setProjections(HashMap<String, Projections> projections) {
        this.projections = projections;
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }

    public HashMap<String, Administrator> getAdmins() {
        return admins;
    }

    public void setAdmins(HashMap<String, Administrator> admins) {
        this.admins = admins;
    }

    public HashMap<String, Client> getClient() {
        return client;
    }

    public void setClient(HashMap<String, Client> client) {
        this.client = client;
    }

}
