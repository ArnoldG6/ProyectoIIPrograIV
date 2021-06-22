package model.servlet;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrator;
import model.Cinema;
import model.Room;
import model.User;

/**
 *
 * @author Vic
 */
@WebServlet(name = "Controller", urlPatterns = {"/registerRoom", "/loadMovies", "/schedule",
    "/PutIn", "/GetOff", "/searchMovies", "/print", "/seePurchases"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            String viewURL = "mainPage.jsp";
            switch (request.getServletPath()) {
                case "/registerRoom":
                    viewURL = this.registerRoom(request, response);
                    break;
                case "/loadMovies":
                    viewURL = this.loadMovies(request, response);
                    break;
                case "/schedule":
                    viewURL = this.schedule(request);
                    break;
                case "/PutIn":
                    viewURL = this.putIn(request);
                    break;
                case "/GetOff":
                    viewURL = this.getOff(request);
                    break;
                case "/searchMovies":
                    viewURL = this.searchMovies(request, response);
                    break;
                case "/print":
                    viewURL = this.print(request);
                    viewURL = this.generarReporte(request);
                    break;
                    case "/seePurchases":
                    viewURL = this.seePurchases(request);
                    break;
                default:
                    viewURL = "mainPage.jsp";
                    break;
            }
            request.getRequestDispatcher(viewURL).forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("mainPage.jsp").forward(request, response);
        }
    }

    public String loadMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cinema.getInstance().updateModel();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            if (user.getRole().equals("ADM")) {
                session.setAttribute("billboards", Cinema.getInstance().getAllMovies());
            } else {
                session.setAttribute("billboards", Cinema.getInstance().getBilldBoards());
            }
        } else {
            session.setAttribute("billboards", Cinema.getInstance().getBilldBoards());
        }

        //request.setAttribute("billboards", Cinema.getInstance().getBilldBoards());
        return "mainPage.jsp";
    }

    public String searchMovies(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cinema.getInstance().updateModel();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        String searchCriteria = request.getParameter("searchCriteria");
        session.setAttribute("moviesResult", Cinema.getInstance().searchMovies(user, searchCriteria));
        return "movieSearch.jsp";
    }

    public String registerRoom(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        try {
            String id = request.getParameter("room_id");
            if (id.isEmpty()) {
                throw new IOException("Ninguno "
                        + "de los campos debe estar vacios.");
            }
            Cinema.getInstance().insertRoom(new Room(id));
        } catch (Exception e) {
            request.getRequestDispatcher("mainPage.jsp").forward(request, response);
            throw e;
        }
        return "mainPage.jsp";
    }

    private String schedule(HttpServletRequest request) throws Exception {
        request.getSession(true).setAttribute("movs", Cinema.getInstance().getAllMovies());
        return "ScheduleProjections.jsp";
    }

    private String putIn(HttpServletRequest request) throws Exception {
        
        //String idMovie = request.getParameter("newBillboard");
        //Cinema.getInstance().scheduleBillboard(idMovie, "SI");
        return "mainPage.jsp";
    }

    private String getOff(HttpServletRequest request) throws Exception {
        //String idMovie = request.getParameter("newBillboard");
        //Cinema.getInstance().scheduleBillboard(idMovie, "NO");
        return "mainPage.jsp";
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

    private String print(HttpServletRequest request) throws Exception {
        //KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
        request.getSession(true).setAttribute("ticks", Cinema.getInstance().getAllTickets());
        return "printTickets.jsp";
    }

    private String generarReporte(HttpServletRequest request) throws Exception {
        return "xxx";
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String seePurchases(HttpServletRequest request) throws Exception {
        try {
            HttpSession session = request.getSession(true);
            User u = (User) session.getAttribute("user");
            session.setAttribute("tickets", Cinema.getInstance().getPurchases1(u.getId()));
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            session.setAttribute("exc", e.getMessage());
            throw e;
        }
        return "/seePurchases.jsp";
    }

}
