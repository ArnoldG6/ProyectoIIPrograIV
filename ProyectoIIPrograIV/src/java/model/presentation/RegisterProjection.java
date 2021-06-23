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
import model.Projections;
@Path("/registerProjection")
@PermitAll
public class RegisterProjection {
    @Context
    HttpServletRequest request;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public void registerProjection(Projections t1) {  
            return ;
    }
    // Projections(String num, String dat, String hor, String room_id, String movie_id)
}