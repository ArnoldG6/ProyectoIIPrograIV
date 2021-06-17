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
import model.Client;
import model.User;

@Path("/register")
@PermitAll
public class Register {
    @Context
    HttpServletRequest request;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public void register(User usuario) {  
            try {
                Cinema.getInstance().insertClient(new Client(usuario.getName(), usuario.getId(), 
                        usuario.getEmail(), usuario.getTelNum(), usuario.getPass()));
            } catch (Exception ex) {
                System.out.println(ex);
                throw new NotFoundException();
            }  
    }
}