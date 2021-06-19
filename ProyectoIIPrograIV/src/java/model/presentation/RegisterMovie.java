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
                final String status = "NO";
                if(movie == null) throw new Exception("Pelicula no creada");
                Movie mov = new Movie(movie.getId(), movie.getName(), 
                        movie.getDescription(), movie.getPublicationYear(), movie.getDirector(),status, 
                        movie.getImgLink());
                if(mov == null) throw new Exception("Usuario no creado");
                Cinema.getInstance().insertMovie(mov);
                System.out.println(movie);
                System.out.println(mov);
            } catch (Exception ex) {
                System.out.println(ex);
                throw new NotFoundException();
            }  
    }
}