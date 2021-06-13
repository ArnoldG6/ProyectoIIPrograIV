package model.entities;

/**
 *
 * @author victo
 */
public class ProjectionsCRUD {
    
    protected static final String CMD_LIST
            = "SELECT id, date, hour, room_id, Movie_id FROM Projections;";
    protected static final String CMD_ADD
            = "INSERT INTO Projections (id, date, hour, room_id, Movie_id) "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT id, date, hour, room_id, Movie_id FROM Projections "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_USERNAME
            = "UPDATE Projections SET date = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_ADMIN_ID
            = "UPDATE Projections SET id = ?"
            + "WHERE date = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM Projections "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT
            = "SELECT COUNT(*) AS total_Projectionss FROM Projections;";
}
