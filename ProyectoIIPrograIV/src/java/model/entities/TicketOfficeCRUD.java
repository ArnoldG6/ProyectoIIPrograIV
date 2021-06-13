package model.entities;

/**
 *
 * @author victo
 */
public class TicketOfficeCRUD {
    
    protected static final String CMD_LIST
            = "SELECT id, occupied, room_id FROM ticketOffice;";
    protected static final String CMD_ADD
            = "INSERT INTO ticketOffice (id, occupied, room_id) "
            + "VALUES (?, ?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT id, occupied, room_id FROM ticketOffice "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_USERNAME
            = "UPDATE ticketOffice SET occupied = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_ADMIN_ID
            = "UPDATE ticketOffice SET id = ?"
            + "WHERE occupied = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM ticketOffice "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT
            = "SELECT COUNT(*) AS total_ticketOffices FROM ticketOffice;";
}
