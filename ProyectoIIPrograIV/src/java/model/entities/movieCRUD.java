/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

/**
 *
 * @author victo
 */
public class movieCRUD {

    protected static final String CMD_LIST
            = "SELECT id, name, description, publicationYear, director FROM movie;";
    protected static final String CMD_ADD
            = "INSERT INTO movie (id, name, description, publicationYear, director) "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT id, name, description, publicationYear, director FROM movie "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_USERNAME
            = "UPDATE movie SET name = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_ADMIN_ID
            = "UPDATE movie SET name = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM movie "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT
            = "SELECT COUNT(*) AS total_movies FROM movie;";
}
