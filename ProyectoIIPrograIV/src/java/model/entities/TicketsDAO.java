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
import model.Administrator;
import model.Tickets;

/**
 *
 * @author victo
 */
public class TicketsDAO implements DAO<String, Tickets> {

    private static TicketsDAO instance = null;

    public int getCount() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
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
        String username;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?useSSL=false", "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(TicketsCRUD.CMD_LIST)) {
                while (rs.next()) {
                    username = rs.getString("id");
                    u.put(username, (new Tickets(username)));
                }
            } catch (SQLException ex) {
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
        try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
                PreparedStatement stm = cnx.prepareStatement(TicketsCRUD.CMD_ADD)) {
            stm.clearParameters();
            stm.setString(1, value.getNumber());
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
            add(u.getNumber(), u);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public Tickets recover(String id, String pass) {
        Tickets result = null;
        String username;
        try {
            try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
                    PreparedStatement stm = cnx.prepareStatement(TicketsCRUD.CMD_RECOVER)) {
                stm.clearParameters();
                stm.setString(1, id);
                stm.setString(2, pass);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        username = rs.getString("id");
                        result = new Tickets(username);
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
    public void update(String id, Tickets value) {
        try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
                PreparedStatement stm = cnx.prepareStatement(TicketsCRUD.CMD_UPDATE_USERNAME)) {
            stm.clearParameters();
            stm.setString(1, id);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(
                        String.format("It couldn't update the register: '%s'", value.getNumber()));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public void update(Tickets u) {
        update(u.getNumber(), u);
    }

    @Override
    public void delete(String id) {
        try {
            try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
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
