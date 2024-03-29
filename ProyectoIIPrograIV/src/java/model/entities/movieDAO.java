/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.io.IOException;
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

/**
 *
 * @author GONCAR4
 */
public class movieDAO implements DAO<String, Movie> {

    private static movieDAO instance = null;

    public int getCount() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(movieCRUD.CMD_COUNT)) {
                if (rs.next()) {
                    return rs.getInt("total_moviers");
                }
            } catch (SQLException ex) {
                Logger.getLogger(movieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(movieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public HashMap<String, Movie> listAll() {
        HashMap<String, Movie> u = new HashMap<>();
        String id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    Statement stm = cnx.createStatement();
                    ResultSet rs = stm.executeQuery(movieCRUD.CMD_LIST)) {
                while (rs.next()) {
                    id = rs.getString("id");
                    u.put(id, (new Movie(id,rs.getString("name"),rs.getString("description")
                            ,rs.getString("publicationYear"),rs.getString("director"),
                            rs.getString("inBillboard"),rs.getString("imgLink"))));
                }
            } catch (SQLException ex) {
                Logger.getLogger(movieDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(movieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public static movieDAO getInstance() throws Exception {
        if (instance == null) {
            instance = new movieDAO();
        }
        return instance;
    }

    @Override
    public void add(String id, Movie value) throws IllegalArgumentException {
        try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                PreparedStatement stm = cnx.prepareStatement(movieCRUD.CMD_ADD)) {
            stm.clearParameters();
            stm.setString(1, value.getId());
            stm.setString(2, value.getDescription());
            stm.setString(3, value.getPublicationYear());
            stm.setString(4, value.getDirector());
            stm.setString(5, value.getInBillboard());
            stm.setString(6, value.getName());
            stm.setString(7, value.getImgLink());
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(
                        String.format("It couldn't add the register: '%s'", id));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    public void add(Movie u) throws IllegalArgumentException {
        try {
            add(u.getName(), u);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public Movie recover(String id, String pass) {
        Movie result = null;
        String id2;
        try {
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    PreparedStatement stm = cnx.prepareStatement(movieCRUD.CMD_RECOVER)) {
                stm.clearParameters();
                stm.setString(1, id);
                stm.setString(2, pass);
                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        id2 = rs.getString("id");
                        result = new Movie(id2,rs.getString("name"),rs.getString("description")
                            ,rs.getString("publicationYear"),rs.getString("director"),
                            rs.getString("inBillboard"),rs.getString("imgLink"));
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.printf("Exception: '%s'%n", ex.getMessage());
        }
        return result;
    }

    @Override
    public void update(String id, Movie value) {
        return;
    }
    public void update(Movie u) {
        update(u.getName(), u);
    }

    @Override
    public void delete(String id) {
        try {
            try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                    PreparedStatement stm = cnx.prepareStatement(movieCRUD.CMD_DELETE)) {
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
        public void update_billboard(String id, String inBillboard, Movie value) {
        try (Connection cnx = DriverManager.getConnection(DAO.path, "root", "root");
                PreparedStatement stm = cnx.prepareStatement(movieCRUD.CMD_UPDATE_BILLBOARD)) {
            stm.clearParameters();
            stm.setString(1, inBillboard);
            stm.setString(2, id);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException(
                        String.format("It couldn't update the register: '%s'", value.getName()));
            }
        } catch (IllegalArgumentException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
}
