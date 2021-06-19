package model.entities;

/**
 *
 * @author victo
 */
public class ProjectionsCRUD {
    
    protected static final String CMD_LIST
            = "SELECT id, date, hour, room_id, Movie_id FROM cinema.Projections;";
    protected static final String CMD_ADD
            = "INSERT INTO cinema.Projections (id, date, hour, room_id, Movie_id) "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String CMD_RECOVER
            = "SELECT id, date, hour, room_id, Movie_id FROM cinema.Projections "
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_USERNAME
            = "UPDATE cinema.Projections SET date = ?"
            + "WHERE id = ?; ";
    protected static final String CMD_UPDATE_ADMIN_ID
            = "UPDATE cinema.Projections SET id = ?"
            + "WHERE date = ?; ";
    protected static final String CMD_DELETE
            = "DELETE FROM cinema.Projections "
            + "WHERE id = ?; ";
    protected static final String CMD_COUNT
            = "SELECT COUNT(*) AS total_Projectionss FROM cinema.Projections;";
}
