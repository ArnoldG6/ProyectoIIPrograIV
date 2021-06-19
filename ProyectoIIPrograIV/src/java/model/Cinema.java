package model;

import java.io.IOException;
import java.util.HashMap;
import model.entities.AdministratorDAO;
import model.entities.ClientDAO;

/**
 *
 * @author victo
 */
public class Cinema {

    private static Cinema instance;
    private HashMap<String, Movie> movies;
    private HashMap<String, Movie> billdBoards;
    private HashMap<String, Projections> projections;
    private HashMap<String, Room> rooms;
    private HashMap<String, Administrator> admins;
    private HashMap<String, Client> clients;

    public Cinema() {
        movies = new HashMap<>();
        billdBoards = new HashMap<>();
        projections = new HashMap<>();
        rooms = new HashMap<>();
        admins = new HashMap<>();
        clients = new HashMap<>();

    }

    public final void updateModel() throws Exception {
        Cinema.getInstance().setAdmins(AdministratorDAO.getInstance().listAll());
        Cinema.getInstance().setClient(ClientDAO.getInstance().listAll());
    }
    public void insertClient(Client c) throws Exception{
        HashMap<String, User> users = Cinema.getInstance().getUsersMap();
        for(HashMap.Entry<String, User> user : users.entrySet()) {
            User u = users.get(user.getKey());
            if(u.getEmail().equals(c.getEmail())) throw new IOException
            ("Error: "+c.getEmail()+" ya está registrado.");
            if(u.getId().equals(c.getId())) throw new IOException
            ("Error: "+c.getId()+" ya está registrado.");
            if(u.getTelNum().equals(c.getTelNum())) throw new IOException
            ("Error: "+u.getTelNum()+" ya está registrado.");
        }
        ClientDAO.getInstance().add(c);

    }
    public static Cinema getInstance() {
        if (instance == null) instance = new Cinema();
        return instance;
    }

    public User seekUser(String id, String clave) throws Exception {
        //updateModel();
        HashMap<String, User> users = Cinema.getInstance().getUsersMap();
        System.out.printf("USUARIOS: %s\n",users.toString());
        User u = users.get(id);
        if (u != null) 
            if (u.correctPswd(clave)) 
                return u;
             else 
                throw new IOException("La contraseña digitada no es correcta");
            

         else
            throw new IOException("El usuario digitado no existe");
        
    }

    public HashMap<String, User> getUsersMap() throws Exception {
        updateModel();
        HashMap<String, User> users = new HashMap<>();
        try {
            users.putAll(admins);
            users.putAll(clients);
            System.out.println(users.toString());
            return users;
        } catch (Exception e) {
            throw e;
        }
    }

    public void insertAdmin(String nom, String id, String em, String cllph, String pass) throws Exception {
        try {
            Administrator ad = new Administrator(nom, id, em, cllph, pass);
            AdministratorDAO.getInstance().add(ad.getId(), ad);
        } catch (Exception e) {
            //throw new IOException("Este ID ya está registrado");
            throw e;
        }
    }

    public void insertClient(String nom, String id, String em, String cllph, String pass) throws Exception {
        try {
            Client cl = new Client(nom, id, em, cllph, pass);
            ClientDAO.getInstance().add(cl.getId(), cl);
        } catch (Exception e) {
            //throw new IOException("Este ID ya está registrado");
            throw e;
        }
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
        return clients;
    }

    public void setClient(HashMap<String, Client> client) {
        this.clients = client;
    }

}
