package model.entities;

public class ClientCRUD {

    protected static final String CMD_LIST
            = "SELECT username, id, email, telNum, pass FROM client;";
    protected static final String CMD_ADD
            = "INSERT INTO client (username, id, email, TelNum, pass) "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT username, id, email, TelNum, pass FROM client "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_USERNAME
            = "UPDATE client SET username = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_ADMIN_ID
            = "UPDATE client SET id = ?"
            + "WHERE username = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM client "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT =
            "SELECT COUNT(*) AS total_clients FROM client;";
}
