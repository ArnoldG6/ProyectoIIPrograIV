package model;

import java.io.IOException;
import java.util.HashMap;
import model.entities.AdministratorDAO;
import model.entities.ClientDAO;
import model.entities.RoomDAO;
import model.entities.TicketOfficeDAO;
import model.entities.movieDAO;

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
    private HashMap<String, ticketOffice> tickets;

    public Cinema() {
        movies = new HashMap<>();
        billdBoards = new HashMap<>();
        projections = new HashMap<>();
        rooms = new HashMap<>();
        admins = new HashMap<>();
        clients = new HashMap<>();
        tickets = new HashMap<>();

    }

    public final void updateModel() throws Exception {
        Cinema.getInstance().setAdmins(AdministratorDAO.getInstance().listAll());
        Cinema.getInstance().setClient(ClientDAO.getInstance().listAll());
        //Cinema.getInstance().setTickets(TicketOfficeDAO.getInstance().listAll());
        HashMap<String, Movie> aux = movieDAO.getInstance().listAll();
        aux.values().removeIf(s -> !s.getInBillboard().equals("NO"));
        Cinema.getInstance().setMovies(aux);
        aux = movieDAO.getInstance().listAll();
        aux.values().removeIf(s -> !s.getInBillboard().equals("SI"));
        Cinema.getInstance().setBilldBoards(aux);
        //System.out.println("BILLBOARDS: "+Cinema.getInstance().getBilldBoards());
        //System.out.println("MOVIES: "+Cinema.getInstance().getMovies());

    }
    
    public ticketOffice ticketFind(String id) throws Exception{
        return getAllTickets().get(id);
    }

    public void insertClient(Client c) throws Exception {
        HashMap<String, User> users = Cinema.getInstance().getUsersMap();
        for (HashMap.Entry<String, User> user : users.entrySet()) {
            User u = users.get(user.getKey());
            if (u.getEmail().equals(c.getEmail())) {
                throw new IOException("Error: " + c.getEmail() + " ya está registrado.");
            }
            if (u.getId().equals(c.getId())) {
                throw new IOException("Error: " + c.getId() + " ya está registrado.");
            }
            if (u.getTelNum().equals(c.getTelNum())) {
                throw new IOException("Error: " + u.getTelNum() + " ya está registrado.");
            }
        }
        ClientDAO.getInstance().add(c);
    }

    public HashMap<String, Movie> getAllMovies() throws Exception {
        return movieDAO.getInstance().listAll();
    }
    
    public HashMap<String, ticketOffice> getAllTickets() throws Exception {
        return TicketOfficeDAO.getInstance().listAll();
    }
    public HashMap<String, ticketOffice> getClientTickets(User user) throws Exception {
        if(user == null) throw new IOException("Sesion Expirada");
        HashMap<String, ticketOffice> aux_tickets = Cinema.getInstance().getAllTickets();
        HashMap<String, ticketOffice> result = new HashMap<String,ticketOffice>();
        ticketOffice value;
        for (HashMap.Entry<String, ticketOffice> entry : aux_tickets.entrySet()) {
                value = aux_tickets.get(entry.getKey());
                if (value.getIdClient().equals(user.getId()) || value.getIdClient().equals(user.getName()))
                        result.put(value.getId(), value);
        }
        return result;
    }
    public void insertRoom(Room c) throws Exception {
        updateModel();
        Room room = Cinema.getInstance().getRooms().get(c.getId());
        if (room == null) {
            RoomDAO.getInstance().add(c.getId(), c);
        } else {
            throw new Exception("La sala " + c.getId() + " ya está registrada.");
        }
    }

    public void insertMovie(Movie m) throws Exception {
        updateModel();
        HashMap<String, Movie> movi = Cinema.getInstance().getMoviesMap();
        for (HashMap.Entry<String, Movie> mo : movi.entrySet()) {
            Movie u = movi.get(mo.getKey());
            if (u.getId().equals(m.getId())) {
                throw new IOException("Error: " + m.getId() + " ya está registrado.");
            }
        }
        movieDAO.getInstance().add(m);
    }

    public static Cinema getInstance() {
        if (instance == null) {
            instance = new Cinema();
        }
        return instance;
    }

    public User seekUser(String id, String clave) throws Exception {
        //updateModel();
        HashMap<String, User> users = Cinema.getInstance().getUsersMap();
        System.out.printf("USUARIOS: %s\n", users.toString());
        User u = users.get(id);
        if (u != null) {
            if (u.correctPswd(clave)) {
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
            users.putAll(admins);
            users.putAll(clients);
            System.out.println(users.toString());
            return users;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public HashMap<String, ticketOffice> getPurchases1(String idIntro) throws Exception {
        updateModel();
        HashMap<String, ticketOffice> ticketP = new HashMap<>();
        try {
            for (int i = 0; i < tickets.size(); i++) {
                if(tickets.get(i).getIdClient().equals(idIntro)){
                    ticketP.put(idIntro, tickets.get(i));
                }
            }
            System.out.println(ticketP.toString());
            return ticketP;
        } catch (Exception e) {
            throw e;
        }
    }

    public HashMap<String, Movie> getMoviesMap() throws Exception {
        updateModel();
        HashMap<String, Movie> movi = new HashMap<>();
        try {
            movi.putAll(movies);
            System.out.println(movi.toString());
            return movi;
        } catch (Exception e) {
            throw e;
        }
    }
        public HashMap<String, Movie> searchMovies(User user, String searchCriteria) throws Exception{
        HashMap<String, Movie> aux_movies;
        HashMap<String, Movie> result = new HashMap<String,Movie>();
        if(user == null) aux_movies = Cinema.getInstance().getBilldBoards();
        else
            if (user.getRole().equals("ADM"))
                aux_movies = Cinema.getInstance().getAllMovies();
            else
                aux_movies = Cinema.getInstance().getBilldBoards();
        Movie value;
        for (HashMap.Entry<String, Movie> entry : aux_movies.entrySet()) {
                value = aux_movies.get(entry.getKey());
                if (value.getDescription().toUpperCase().contains(searchCriteria.toUpperCase())
                        || value.getDirector().toUpperCase().contains(searchCriteria.toUpperCase())
                        || value.getName().toUpperCase().contains(searchCriteria.toUpperCase()) 
                        || value.getId().toUpperCase().contains(searchCriteria.toUpperCase())) 
                        result.put(value.getId(), value);
        }
        return result;
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

    public void insertTicketOffice(String id) throws Exception {
        /*try {
            
            // public ticketOffice(String _id, String idClient, String movie_name, int occup, double to)
            ticketOffice t1 = new ticketOffice(id);
            TicketOfficeDAO.getInstance().add(t1.getId(), t1);
        } catch (Exception e) {
            //throw new IOException("Este ID ya está registrado");
            throw e;
        }*/
        return ;
    }

    public void scheduleBillboard(String id, String inB) throws Exception {
        updateModel();
        Movie movie = Cinema.getInstance().getAllMovies().get(id);
        if(movie == null) throw new IOException("La pelicula no existe");
        movie.setInBillboard(inB);
        movieDAO.getInstance().update_billboard(id, inB, movie);
        
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

    public HashMap<String, ticketOffice> getTickets() {
        return tickets;
    }

    public void setTickets(HashMap<String, ticketOffice> tickets) {
        this.tickets = tickets;
    }

}
