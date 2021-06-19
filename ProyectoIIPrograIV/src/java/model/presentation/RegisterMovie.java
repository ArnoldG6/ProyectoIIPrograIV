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
import model.Movie;

@Path("/registerMovie")
@PermitAll
public class RegisterMovie {
    @Context
    HttpServletRequest request;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public void register(Movie movie) {  
            try {
                if(movie == null) throw new Exception("Pelicula no creada");
                Movie cli = new Movie(movie.getId(), movie.getName(), 
                        movie.getDescription(), movie.getPublicationYear(), movie.getDirector());
                if(cli == null) throw new Exception("Usuario no creado");
                Cinema.getInstance().insertMovie(cli);
                System.out.println(movie);
                System.out.println(cli);
            } catch (Exception ex) {
                System.out.println(ex);
                throw new NotFoundException();
            }  
    }
}