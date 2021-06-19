package model.entities;
public class RoomCRUD {
    protected static final String CMD_LIST
            = "SELECT id FROM cinema.Room;";
    protected static final String CMD_ADD
            = "INSERT INTO cinema.Room (id) "
            + "VALUES (?); ";
    protected static final String CMD_RECOVER
            = "SELECT id FROM cinema.Room"
            + "WHERE id = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM cinema.Room "
            + "WHERE id = ?; ";
    protected static final String path = "jdbc:mysql://localhost:3306/university?useSSL=false";
}
