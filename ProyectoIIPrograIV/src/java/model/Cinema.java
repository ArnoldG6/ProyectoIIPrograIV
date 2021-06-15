package model;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private HashMap<String, Client> client;

    public Cinema() {
        movies = new HashMap<>();
        billdBoards = new HashMap<>();
        projections = new HashMap<>();
        rooms = new HashMap<>();
        admins = new HashMap<>();
        client = new HashMap<>();

    }

    public final void updateModel() throws Exception {
        Cinema.getInstance().setAdmins(AdministratorDAO.getInstance().listAll());
        Cinema.getInstance().setClient(ClientDAO.getInstance().listAll());
        try {
            insertAdmin("root", "root", "root", "root", "root");
        } catch (Exception ex) {
            Logger.getLogger(Cinema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Cinema getInstance() {
        if (instance == null) {
            instance = new Cinema();
        }
        return instance;
    }

    public User seekUser(String cedula, String clave) throws Exception {
        updateModel();
        HashMap<String, User> users = getUsersMap();
        System.out.printf("USUARIOS: %d\n",users.size());
        User u = users.get(cedula);
        if (u != null) {
            if (u.valPass(clave)) {
                return u;
            } else {
                throw new IOException("La contraseña digitada no es correcta");
            }

        } else {
            throw new IOException("El usuario digitado no existe");
        }
    }

    public HashMap<String, User> getUsersMap() throws Exception {
        updateModel();
        HashMap<String, User> users = new HashMap<>();
        try {
            users.putAll(getAdmins());
            users.putAll(getClient());
            users.toString();
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
        return client;
    }

    public void setClient(HashMap<String, Client> client) {
        this.client = client;
    }

}
