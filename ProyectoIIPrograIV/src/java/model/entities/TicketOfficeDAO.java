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
import model.ticketOffice;

/**
 *
 * @author victo
 */
public class TicketOfficeDAO implements DAO<String, ticketOffice> {

    private static TicketOfficeDAO instance = null;

    public int getCount() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(TicketOfficeCRUD.CMD_COUNT)) {
                if (rs.next()) {
                    return rs.getInt("total_ticketOffices");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TicketOfficeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketOfficeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
    @Override
    public HashMap<String, ticketOffice> listAll() {
        HashMap<String, ticketOffice> u = new HashMap<>();
        String id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(TicketOfficeCRUD.CMD_LIST)) {
                while (rs.next()) {
                    id = rs.getString("id");
                    u.put(id, (new ticketOffice(id,
                               rs.getString("idClient"),
                            rs.getString("nomMovie"),
                            rs.getInt("occupied"),
                            Double.parseDouble(rs.getString("total")))));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TicketOfficeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TicketOfficeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public static TicketOfficeDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new TicketOfficeDAO();
        }
        return instance;
    }

    @Override
    public void add(String id, ticketOffice value) throws IllegalArgumentException {
        try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                PreparedStatement stm = cnx.prepareStatement(TicketOfficeCRUD.CMD_ADD)) {
            stm.clearParameters();
            stm.setString(1, value.getId());
            stm.setString(2, value.getIdClient());
            stm.setString(3, value.getMovie());
            stm.setInt(4, value.getOccupied());
            stm.setString(5, "N/A");
            stm.setString(6, String.valueOf(value.getTotal()));
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(
                        String.format("It couldn't add the register: '%s'", id));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public void add(ticketOffice u) throws IllegalArgumentException {
        try {
            add(u.getId(), u);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public ticketOffice recover(String id, String pass) {
        ticketOffice result = null;
        String username;
        try {
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    PreparedStatement stm = cnx.prepareStatement(TicketOfficeCRUD.CMD_RECOVER)) {
                stm.clearParameters();
                stm.setString(1, id);
                stm.setString(2, pass);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        username = rs.getString("id");
                        result = new ticketOffice(username,
                               rs.getString("idClient"),
                            rs.getString("nomMovie"),
                            rs.getInt("occupied"),
                            Double.parseDouble(rs.getString("total")));
                        
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Exception: '%s'%n", ex.getMessage());
        }
        return result;
    }

    @Override
    //This update only updates username, not sure about updating id
    public void update(String id, ticketOffice value) {
        try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                PreparedStatement stm = cnx.prepareStatement(TicketOfficeCRUD.CMD_UPDATE_USERNAME)) {
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

    public void update(ticketOffice u) {
        update(u.getId(), u);
    }

    @Override
    public void delete(String id) {
        try {
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    PreparedStatement stm = cnx.prepareStatement(TicketOfficeCRUD.CMD_DELETE)) {
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
