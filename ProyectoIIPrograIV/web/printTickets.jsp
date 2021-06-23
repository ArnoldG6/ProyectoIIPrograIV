<%@page import="model.ticketOffice"%>
<%@page import="java.util.Map"%>
<%@page import="model.Movie"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User usua = (User) session.getAttribute("user");%>
<%HashMap<String, ticketOffice> ticks = (HashMap<String, ticketOffice>) session.getAttribute("ticks");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Imprimir Tiquetes</title>
        <link rel="icon" href="/ExamenPrograIV/images/landing-page.png" >
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css">         
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="js/menu.js"></script>
    </head>
    <body class="bg-dark text-white">
        <div class="p-3 bg-dark border w-90 mx-auto">
            <h4 class="card-title mt-3 text-center">NGC Cinema</h4> 
            <img class="w-100 mx-auto" src="images/csm.png" height="250" width = "800">
        </div>

        <div class = "form-group">
            <H1 class = "text-center text-white">Imprimir Tiquetes</H1>
            <div>&nbsp;</div>
            <div class="text-white text-center">Seleccione alguno de los tiquetes para generar el archivo ".PDF"</div>
            <% if (ticks != null) { %>
            <div class="card-body bg-dark text-white">
                <table class = "table table-condensed">
                    <tr>
                        <th class="text-center text-white">ID tiquete</th>
                        <th class="text-center text-white">ID Cliente</th>
                        <th class="text-center text-white">Pelicula</th>
                        <th class="text-center text-white">Sala</th>
                        <th class="text-center text-white">Total</th>
                        <th class="text-center text-white">Descargar</th>
                    </tr>
                    <%for (Map.Entry<String, ticketOffice> entry : ticks.entrySet()) { %>
                    <%  ticketOffice s = ticks.get(entry.getKey());%>
                    <tr>
                        <td class="text-center text-white"><%= s.getId()%></td>
                        <td class="text-center text-white"><%= s.getIdClient()%></td>
                        <td class="text-center text-white"><%= s.getMovie()%></td>
                        <td class="text-center text-white">N/A</td>
                        <td class="text-center text-white"><%= s.getTotalS()%></td>
                        <td class="text-center text-white">
                            <a class="navbar-brand" href="/ExamenPrograIV/pdf?comboTickets=<%= s.getId()%>"
                                download="<%=s.getId()%>_tiquete.pdf">
                                <button class ="btn btn-outline-light form-control">Generar PDF</button>
                            </a>
                        </td>
                    </tr>
                     <% }%>
                </table>
            </div>

            <% }else {%>
            <div class="text-white text-center">No hay compras disponibles para proyectar</div>
            <% }%>
            <div>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <object type="text/html" data="Footer.html"></object>
        </div>
    </body>
</html>
