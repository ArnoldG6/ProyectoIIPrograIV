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

/**
 *
 * @author victo
 */
public class TicketOfficeDAO implements DAO<String, Administrator> {
    
    private static AdministratorDAO instance = null;

    public int getCount() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(AdministratorCRUD.CMD_COUNT)) {
                if (rs.next()) 
                    return rs.getInt("total_administrators");                
            } catch (SQLException ex) {
                Logger.getLogger(AdministratorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministratorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public HashMap<String, Administrator> listAll() {
        HashMap<String, Administrator> u = new HashMap<>();
        String username;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?useSSL=false", "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(AdministratorCRUD.CMD_LIST)) {
                while (rs.next()) {
                    username = rs.getString("username");
                    u.put(username, (new Administrator(username, rs.getString("id"),
                            rs.getString("email"), rs.getString("TelNum"), rs.getString("pass"))));
                }   
            } catch (SQLException ex) {
                Logger.getLogger(AdministratorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdministratorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public static AdministratorDAO getInstance() throws Exception {
        if (instance == null) 
            instance = new AdministratorDAO();
        return instance;
    }

    @Override
    public void add(String id, Administrator value) throws IllegalArgumentException {
        try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
                PreparedStatement stm = cnx.prepareStatement(AdministratorCRUD.CMD_ADD)) {
            stm.clearParameters();
            stm.setString(1, value.getName());
            stm.setString(2, value.getId());
            stm.setString(3, value.getEmail());
            stm.setString(4, value.getTelNum());
            stm.setString(5, value.getPass());
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(
                        String.format("It couldn't add the register: '%s'", id));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public void add(Administrator u) throws IllegalArgumentException {
        try {
            add(u.getId(), u);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public Administrator recover(String id, String pass) {
        Administrator result = null;
        String username;
        try {
            try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
                    PreparedStatement stm = cnx.prepareStatement(AdministratorCRUD.CMD_RECOVER)) {
                stm.clearParameters();
                stm.setString(1, id);
                stm.setString(2, pass);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        username = rs.getString("username");
                        result = new Administrator(username, rs.getString("id"),
                                rs.getString("email"), rs.getString("TelNum"), rs.getString("pass"));
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
    public void update(String id, Administrator value) {
        try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
                PreparedStatement stm = cnx.prepareStatement(AdministratorCRUD.CMD_UPDATE_USERNAME)) {
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

    public void update(Administrator u) {
        update(u.getId(), u);
    }

    @Override
    public void delete(String id) {
        try {
            try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "root");
                    PreparedStatement stm = cnx.prepareStatement(AdministratorCRUD.CMD_DELETE)) {
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
