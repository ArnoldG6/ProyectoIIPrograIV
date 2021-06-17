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

/**
 *
 * @author victo
 */
public class ProjectionsDAO implements DAO<String, Projections> {

    private static ProjectionsDAO instance = null;

    public int getCount() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(ProjectionsCRUD.CMD_COUNT)) {
                if (rs.next()) {
                    return rs.getInt("total_Projections");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectionsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public HashMap<String, Projections> listAll() {
        HashMap<String, Projections> u = new HashMap<>();
        String id, roomId, movieId;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(ProjectionsCRUD.CMD_LIST)) {
                Room r1;
                Movie m1;
                while (rs.next()) {
                    try {
                        roomId = rs.getString("room_id");
                        movieId = rs.getString("Movie_id");
                        r1 = RoomDAO.getInstance().listAll().get(roomId);
                        m1 = movieDAO.getInstance().listAll().get(movieId);
                        if(r1==null || m1==null){
                            throw new Exception("Error de movie o room DAO");
                        }
                        id = rs.getString("id");
                        u.put(id, (new Projections(id, rs.getString("date"), rs.getString("hour"),
                                r1, m1)));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProjectionsDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjectionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public static ProjectionsDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new ProjectionsDAO();
        }
        return instance;
    }

    @Override
    public void add(String id, Projections value) throws IllegalArgumentException {
        try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                PreparedStatement stm = cnx.prepareStatement(ProjectionsCRUD.CMD_ADD)) {
            stm.clearParameters();
            stm.setString(1, value.getNumber());
            stm.setString(2, value.getDate());
            stm.setString(3, value.getHour());
            stm.setString(4, value.getRooms().getId());
            stm.setString(5, value.getMov().getId());
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(
                        String.format("It couldn't add the register: '%s'", id));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public void add(Projections u) throws IllegalArgumentException {
        try {
            add(u.getNumber(), u);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public Projections recover(String id, String pass) {
        Projections result = null;
        return result;
    }

    @Override
    //This update only updates username, not sure about updating id
    public void update(String id, Projections value) {
        try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                PreparedStatement stm = cnx.prepareStatement(ProjectionsCRUD.CMD_UPDATE_USERNAME)) {
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

    public void update(Projections u) {
        update(u.getNumber(), u);
    }

    @Override
    public void delete(String id) {
        try {
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    PreparedStatement stm = cnx.prepareStatement(ProjectionsCRUD.CMD_DELETE)) {
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
