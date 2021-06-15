package model.presentation;

import model.User;
import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import model.Cinema;

@Path("/login")
@PermitAll
public class Login {

    @Context
    HttpServletRequest request;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User login(User usuario) {
        User logged = null;
        try {
            //logged = Cinema.getInstance().getUsersMap().get(usuario.getId());
            logged = Cinema.getInstance().seekUser(usuario.getId(), usuario.getPass());
            //if (!logged.getPass().equals(usuario.getPass())) {
            //    throw new Exception("Clave incorrecta");
            //}
            request.getSession(true).setAttribute("user", logged);
            return logged;
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }

    @DELETE
    public void logout() {
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");
        session.invalidate();
    }

}
