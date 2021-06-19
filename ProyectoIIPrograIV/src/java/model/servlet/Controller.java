package model.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cinema;
import model.Room;

/**
 *
 * @author Vic
 */
@WebServlet(name = "Controller", urlPatterns = {"/registerRoom"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            String viewURL = "index.html";
            switch (request.getServletPath()) {
                case "/registerRoom":
                    viewURL = this.registerTeacher(request, response);
                    break;
                default:
                    viewURL = "index.jsp";
            }
            request.getRequestDispatcher(viewURL).forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }

    public String registerTeacher(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            String id = request.getParameter("room_id");
            if (id.isEmpty()) {
                throw new IOException("Ninguno "
                        + "de los campos debe estar vacios.");
            }
            Cinema.getInstance().insertRoom(new Room(id));
            request.getRequestDispatcher("/registerRoom.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("index.html").forward(request, response);
            throw e;
        }
        return "/index.html";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
