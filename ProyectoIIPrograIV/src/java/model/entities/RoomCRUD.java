package model.entities;
public class RoomCRUD {
    protected static final String CMD_LIST
            = "SELECT id FROM cinema.room;";
    protected static final String CMD_ADD
            = "INSERT INTO cinema.room (id) "
            + "VALUES (?); ";
    protected static final String CMD_RECOVER
            = "SELECT id FROM cinema.room"
            + "WHERE id = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM cinema.room "
            + "WHERE id = ?; ";
}
