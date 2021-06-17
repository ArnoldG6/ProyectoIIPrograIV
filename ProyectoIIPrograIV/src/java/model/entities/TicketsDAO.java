package model.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Movie;
import model.Projections;
import model.Room;
import model.Tickets;
import model.ticketOffice;

/**
 *
 * @author victo
 */
public class TicketsDAO implements DAO<String, Tickets> {

    private static TicketsDAO instance = null;

    public int getCount() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(AdministratorCRUD.CMD_COUNT)) {
                if (rs.next()) {
                    return rs.getInt("total_Tickets");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TicketsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public HashMap<String, Tickets> listAll() {
        HashMap<String, Tickets> u = new HashMap<>();
        String id, roomId, movieId, ticketId, projectId;
        Room r1;
        Movie m1;
        ticketOffice t1;
        Projections pro1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(TicketsCRUD.CMD_LIST)) {
                HashMap<String, Movie> movs = movieDAO.getInstance().listAll();
                HashMap<String, Room> rooms = RoomDAO.getInstance().listAll();
                HashMap<String, ticketOffice> ticketOffices = TicketOfficeDAO.getInstance().listAll();
                HashMap<String, Projections> projects = ProjectionsDAO.getInstance().listAll();
                while (rs.next()) {
                    try {
                        roomId = rs.getString("Projections_room_id");
                        movieId = rs.getString("Projections_Movie_id");
                        ticketId = rs.getString("ticketOffice_id");
                        projectId = rs.getString("Projections_id");
                        r1 = rooms.get(roomId);
                        m1 = movs.get(movieId);
                        t1 = ticketOffices.get(roomId);
                        pro1 = projects.get(movieId);
                        if (r1 == null || m1 == null || t1 == null || pro1 == null) {
                            throw new Exception("Error de movie o room DAO");
                        }
                        id = rs.getString("id");
                        u.put(id, (new Tickets(id, t1, r1,
                                pro1, m1)));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(TicketsDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(TicketsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public static TicketsDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new TicketsDAO();
        }
        return instance;
    }

    @Override
    public void add(String id, Tickets value) throws IllegalArgumentException {
        try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                PreparedStatement stm = cnx.prepareStatement(TicketsCRUD.CMD_ADD)) {
            stm.clearParameters();
            stm.setString(1, value.getId());
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(
                        String.format("It couldn't add the register: '%s'", id));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public void add(Tickets u) throws IllegalArgumentException {
        try {
            add(u.getId(), u);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public Tickets recover(String id, String pass) {
        Tickets result = null;
        return result;
    }

    @Override
    //This update only updates username, not sure about updating id
    public void update(String id, Tickets value) {
        try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                PreparedStatement stm = cnx.prepareStatement(TicketsCRUD.CMD_UPDATE_USERNAME)) {
            stm.clearParameters();
            stm.setString(1, id);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(
                        String.format("It couldn't update the register: '%s'", value.getId()));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public void update(Tickets u) {
        update(u.getId(), u);
    }

    @Override
    public void delete(String id) {
        try {
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    PreparedStatement stm = cnx.prepareStatement(TicketsCRUD.CMD_DELETE)) {
                stm.clearParameters();
                stm.setString(1, id);
                if (stm.executeUpdate() != 1) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Exception: '%s'%n", ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

}
