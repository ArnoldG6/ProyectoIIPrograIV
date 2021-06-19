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
                System.out.println(room.getId());
                if(room == null) throw new Exception("Sala no creada");
                Room room2 = new Room(room.getId());
                if(room2 == null) throw new Exception("Sala 2 no creada");
                Cinema.getInstance().insertRoom(room2);
                System.out.println(room.getId());
                System.out.println(room2.getId());
            } catch (Exception ex) {
                System.out.println(ex);
                throw new NotFoundException();
            }  
    }
}
