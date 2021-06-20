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
import model.ticketOffice;

/**
 *
 * @author Vic
 */

@Path("/purchase")
@PermitAll
public class Purchase {
    @Context
    HttpServletRequest request;
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public void register(ticketOffice ticketOffice1) {  
            try {
                //ticketOffice1
                if(ticketOffice1 == null) throw new Exception("ticketOffice1 no creado");
                ticketOffice ticket1 = new ticketOffice(ticketOffice1.getId());
                if(ticket1 == null) throw new Exception("Usuario no creado");
                Cinema.getInstance().insertTicketOffice(ticket1.getId());
                System.out.println(ticketOffice1);
                System.out.println(ticket1);
            } catch (Exception ex) {
                System.out.println(ex);
                throw new NotFoundException();
            }  
    }
}
