package model.entities;
public class RoomCRUD {
    protected static final String CMD_LIST
            = "SELECT * FROM Room;";
    protected static final String CMD_ADD
            = "INSERT INTO Room (id) "
            + "VALUES (?); ";
    protected static final String CMD_RECOVER
            = "SELECT * FROM Room"
            + "WHERE id = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM Room "
            + "WHERE id = ?; ";
    protected static final String path = "jdbc:mysql://localhost:3306/university?useSSL=false";
}
