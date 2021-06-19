package model.presentation;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import model.Cinema;
import model.Room;

/**
 *
 * @author victo
 */
@Path("/registerRoom")
@PermitAll
public class RegisterRoom {
    @Context
    HttpServletRequest request;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public void register(Room room) {  
            try {
                if(room == null) throw new Exception("Sala no creada");
                Room cli = new Room(room.getId());
                if(cli == null) throw new Exception("Sala no creada");
                Cinema.getInstance().insertRoom(cli);
                System.out.println(room);
                System.out.println(cli);
            } catch (Exception ex) {
                System.out.println(ex);
                throw new NotFoundException();
            }  
    }
}
