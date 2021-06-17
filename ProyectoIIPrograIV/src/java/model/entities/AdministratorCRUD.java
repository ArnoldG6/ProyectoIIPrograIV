package model.entities;

public class AdministratorCRUD {

    protected static final String CMD_LIST
            = "SELECT username, id, email, telNum, pass FROM cinema.administrator;";
    protected static final String CMD_ADD
            = "INSERT INTO cinema.administrator (username, id, email, TelNum, pass) "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT username, id, email, TelNum, pass FROM cinema.administrator "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_USERNAME
            = "UPDATE cinema.administrator SET username = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_ADMIN_ID
            = "UPDATE cinema.administrator SET id = ?"
            + "WHERE username = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM cinema.administrator "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT
            = "SELECT COUNT(*) AS total_administrators FROM cinema.administrator;";
}
