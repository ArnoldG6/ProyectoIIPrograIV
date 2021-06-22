/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

public class movieCRUD {

    protected static final String CMD_LIST
            = "SELECT id, description, publicationYear, director, inBillboard, name, imgLink FROM cinema.movie;";
    protected static final String CMD_ADD
            = "INSERT INTO cinema.movie (id, description, publicationYear, director, inBillboard, name,imgLink) "
            + "VALUES (?, ?, ?, ?, ?,?,?); ";
    protected static final String CMD_RECOVER
            = "SELECT id, description, publicationYear, director, inBillboard, name, imgLink FROM cinema.movie "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_BILLBOARD
            = "UPDATE cinema.movie SET inBillboard = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM cinema.movie "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT
            = "SELECT COUNT(*) AS total_movies FROM cinema.movie;";
}
