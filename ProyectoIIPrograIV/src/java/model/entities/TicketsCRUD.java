package model.entities;

/**
 *
 * @author victo
 */
public class TicketsCRUD {
    
        protected static final String CMD_LIST
            = "SELECT id, ticketOffice_id, ticketOffice_room_id FROM Tickets;";
    protected static final String CMD_ADD
            = "INSERT INTO Tickets (id, ticketOffice_id, ticketOffice_room_id) "
            + "VALUES (?, ?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT id, ticketOffice_id, ticketOffice_room_id FROM Tickets "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_USERNAME
            = "UPDATE Tickets SET ticketOffice_id = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_ADMIN_ID
            = "UPDATE Tickets SET id = ?"
            + "WHERE ticketOffice_id = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM Tickets "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT
            = "SELECT COUNT(*) AS total_Tickets FROM Tickets;";
}
