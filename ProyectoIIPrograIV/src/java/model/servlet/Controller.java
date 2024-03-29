package model.servlet;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cinema;
import model.Room;
import model.User;
import model.ticketOffice;

/**
 *
 * @author Vic
 */
@WebServlet(name = "Controller", urlPatterns = {"/registerRoom", "/loadMovies", "/schedule",
    "/PutIn", "/GetOff", "/searchMovies", "/print", "/seePurchases", "/pdf"})
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
                    break;
                case "/pdf":
                    viewURL = this.generarReporte(request, response);
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

        String idMovie = request.getParameter("newBillboard");
        Cinema.getInstance().scheduleBillboard(idMovie, "SI");
        return "mainPage.jsp";
    }

    private String getOff(HttpServletRequest request) throws Exception {
        String idMovie = (String) request.getParameter("newBillboard");
        System.out.println("ALGOXD: " + idMovie);
        Cinema.getInstance().scheduleBillboard(idMovie, "NO");
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

    private String generarReporte(HttpServletRequest request, HttpServletResponse response) throws Exception {
        OutputStream out = response.getOutputStream();
        try {
            String numTick = request.getParameter("comboTickets");
            HashMap<String, ticketOffice> tickets
                    = (HashMap<String, ticketOffice>) request.getSession(true).getAttribute("ticks");
            ticketOffice t = tickets.get(numTick);
            if (t == null || tickets == null) {
                System.out.println("ALGO XDNT: " + numTick);

            } else {
                try {
                    Date actualDate = new Date();
                    Document documento = new Document();
                    PdfWriter.getInstance(documento, out);
                    documento.open();
                    Paragraph par1 = new Paragraph();
                    Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLACK);
                    //Image img = Image.getInstance("img.png");     
                    //img.setAlignment(Element.ALIGN_CENTER);
                    par1.add(new Phrase("REPORTE DE TICKET", fontTitulo));
                    par1.add(new Phrase(Chunk.NEWLINE));
                    par1.setAlignment(Element.ALIGN_CENTER);
                    par1.add(new Phrase(Chunk.NEWLINE));
                    par1.add(new Phrase("FECHA DE EMISION: "+actualDate.toString()));
                    par1.add(new Phrase(Chunk.NEWLINE));
                    par1.add(new Phrase("ID: " + t.getId()));
                    par1.add(new Phrase(Chunk.NEWLINE));
                    par1.add(new Phrase("ID Cliente: " + t.getIdClient()));
                    par1.add(new Phrase(Chunk.NEWLINE));
                    par1.add(new Phrase("Ocupado: " + t.getOccupied()));
                    par1.add(new Phrase(Chunk.NEWLINE));
                    par1.add(new Phrase("Pelicula: " + t.getMovie()));
                    par1.add(new Phrase(Chunk.NEWLINE));
                    par1.add(new Phrase("Total: " + t.getTotal()));
                    par1.add(new Phrase(Chunk.NEWLINE));
                    //documento.add(img);
                    documento.add(par1);
                    documento.close();
                    response.setContentType("application/pdf");
                    response.addHeader("Content-disposition", "inline");
                } catch (DocumentException exc) {
                    throw new IOException(exc.getMessage());
                } finally {
                    out.close();
                }
                System.out.println(t.getId());
            }
            response.setHeader("content-disposition", "attachment;filename=" + request.getParameter("comboTickets"));
        } catch (Exception e) {
            throw e;
        }
        return "printTickets.jsp";
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String seePurchases(HttpServletRequest request) throws Exception {
        try {
            User user = (User) request.getSession(true).getAttribute("user");
            request.getSession(true).setAttribute("ticks", Cinema.getInstance().getClientTickets(user));
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            session.setAttribute("exc", e.getMessage());
            throw e;
        }
        return "/seePurchases.jsp";
    }

}
