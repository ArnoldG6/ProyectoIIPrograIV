package model.entities;

public class RoomCRUD {
    protected static final String CMD_LIST
            = "SELECT * FROM room;";
    protected static final String CMD_ADD
            = "INSERT INTO room ( ) "
            + "VALUES (?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT * FROM room"
            + "WHERE  = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM room "
            + "WHERE  = ?; ";

}
