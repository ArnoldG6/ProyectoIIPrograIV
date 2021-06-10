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
import model.Room;

public class RoomDAO implements DAO<String, Room> {
    private static RoomDAO instance = null;
    @Override
    public HashMap<String, Room> listAll() {
        HashMap<String, Room> u = new HashMap<>();
        String id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection(RoomCRUD.path,"root","root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(RoomCRUD.CMD_LIST)) {
                while (rs.next()) {
                    id = rs.getString("id");
                    u.put(id, new Room(id));
                }
            } catch (SQLException ex) {
                Logger.getLogger(movieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(movieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    public static RoomDAO getInstance() throws Exception {
        if (instance == null) instance = new RoomDAO();
        return instance;
    }
    @Override
    public void add(String id, Room value) {
        try (Connection cnx = DriverManager.getConnection(RoomCRUD.path,"root","root");
            PreparedStatement stm = cnx.prepareStatement(movieCRUD.CMD_ADD)) {
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
    @Override
    public Room recover(String id, String pass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(String id, Room value) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
