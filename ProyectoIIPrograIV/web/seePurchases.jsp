<%-- 
    Document   : seePurchases
    Created on : 22/06/2021, 02:33:42 PM
    Author     : Vic
--%>
<%@page import="model.User"%>
<%@page import="java.util.Map"%>
<%@page import="model.ticketOffice"%>
<%@page import="model.ticketOffice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User usua = (User) session.getAttribute("user");%>
<% Map<String, ticketOffice> tickets = (Map<String, ticketOffice>) session.getAttribute("tickets");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>See Purchases</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css">         
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link rel="icon" href="/ExamenPrograIV/images/landing-page.png" >
    </head>
    <body class="bg-dark text-white">
        <%if (tickets != null) {%>
        <div class="d-grid gap-3 p-1 bg-dark container">

            <table class = "table table-condensed border">Lista de Compras
                <tr>
                    <th class="text-left text-white">Nombre del cliente</th>
                    <th class="text-left text-white">Numero del tickete</th>
                    <th class="text-left text-white">Nombre de la pelicula</th>
                    <th class="text-left text-white">Total de la compra</th>
                </tr>

                <tr>
                    <%for (ticketOffice t : tickets.values()) {%>
                    <td class= "text-left text-white"> <%=usua.getName()%> </td>
                    <td class= "text-left text-white"> <%=t.getId()%> </td>
                    <td class= "text-left text-white"> <%=t.getMoviee()%> </td>
                    <td class= "text-left text-white"> <%=String.valueOf(t.getTotal())%> </td>
                </tr>
                <% } %>
            </table>
        </div>
        <%}%>
    </body>
</html>
