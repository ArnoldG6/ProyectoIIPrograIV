package model.entities;

public class ClientCRUD {

    protected static final String CMD_LIST
            = "SELECT username, id, email, telNum, pass FROM cinema.client;";
    protected static final String CMD_ADD
            = "INSERT INTO cinema.client (username, id, email, TelNum, pass) "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT username, id, email, TelNum, pass FROM cinema.client "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_USERNAME
            = "UPDATE cinema.client SET username = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_ADMIN_ID
            = "UPDATE cinema.client SET id = ?"
            + "WHERE username = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM cinema.client "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT =
            "SELECT COUNT(*) AS total_clients FROM cinema.client;";
}
