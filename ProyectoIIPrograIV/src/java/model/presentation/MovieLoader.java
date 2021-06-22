package model.presentation;

import java.sql.Array;
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
    public Array loadMovies() {
        try {
            Cinema.getInstance().updateModel();
            Array billboards = (Array) Cinema.getInstance().getBilldBoards().values();
            request.getSession(true).setAttribute("billboards", billboards);
            return billboards;
        } catch (Exception ex) {
            System.out.println(ex);
            throw new NotFoundException();
        }
    }
}
