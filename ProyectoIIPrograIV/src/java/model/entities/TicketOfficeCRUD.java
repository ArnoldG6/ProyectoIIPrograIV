package model.entities;

public class TicketOfficeCRUD {
    
    protected static final String CMD_LIST
            = "SELECT id, idClient, movie_name, occupied, total, room_id FROM cinema.ticketOffice;";
    protected static final String CMD_ADD
            = "INSERT INTO cinema.ticketOffice (id, idClient, movie_name, occupied, total, room_id) "
            + "VALUES (?, ?, ?, ?, ?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT id, idClient, movie_name, occupied, total, room_id FROM cinema.ticketOffice "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_USERNAME
            = "UPDATE cinema.ticketOffice SET occupied = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_ADMIN_ID
            = "UPDATE cinema.ticketOffice SET id = ?"
            + "WHERE occupied = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM cinema.ticketOffice "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT
            = "SELECT COUNT(*) AS total_ticketOffices FROM cinema.ticketOffice;";
}
