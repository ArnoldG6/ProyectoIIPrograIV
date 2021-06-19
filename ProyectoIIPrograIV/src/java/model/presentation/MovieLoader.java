package model.presentation;
import java.util.HashMap;
import model.Cinema;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import model.Movie;

@Path("/loadMovies")
@PermitAll
public class MovieLoader {
    @Context
    HttpServletRequest request;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public HashMap<String, Movie> login() {   
            try {
                HashMap<String, Movie> billboards = Cinema.getInstance().getBilldBoards();
                request.getSession(true).setAttribute("billboards", billboards);
                return billboards;
            } catch (Exception ex) {
                System.out.println(ex);
                throw new NotFoundException();
            }  
    }
}