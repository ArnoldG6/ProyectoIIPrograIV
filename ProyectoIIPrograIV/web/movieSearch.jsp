<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="model.Movie"%>
<% User user = (User) session.getAttribute("user");%>
<%HashMap<String, Movie> moviesResult = (HashMap<String, Movie>) session.getAttribute("moviesResult"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="/ExamenPrograIV/images/landing-page.png" >
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css">         
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
        <script src="js/register.js"></script>
        <script src="js/menu.js"></script>
        <script src="js/login.js"></script>
        <script src="js/booking.js"></script>
        <title>Resultados de La Busqueda</title>
    </head>
    <body class="bg-dark text-white">
        <div class="p-3 bg-dark border w-90 mx-auto">
            <h4 class="card-title mt-3 text-center">NGC Cinema</h4> 
            <img class="w-100 mx-auto" src="images/csm.png" height="250" width = "800">
        </div>
        <div class="d-flex flex-column min-vh-100 bg-dark text-white">
            <div class="container">
                <h1 class="text-white text-center">Resultados de la Búsqueda</h1>
                <% if (moviesResult != null) { %>
                <% if (moviesResult.size() == 0) {%>
                <div  class="text-center">
                    No se encontraron peliculas referentes al criterio de búsqueda
                </div>
                <% }%>

                <div class="row p-1 bg-dark column card-body w-15">
                    <%for (HashMap.Entry<String, Movie> entry : moviesResult.entrySet()) { %>   
                    <% Movie sub = moviesResult.get(entry.getKey());%>


                    <div class="card p-3 bg-dark col w-15">
                        <a href="#" id="imagen1" class="p-3 bg-dark text-center" >
                            <img src='<%=sub.getImgLink()%>' height="150" width = "150">
                        </a>
                        <div class="text-center" ><label class="card-title text-center"><%= "ID: " + sub.getId() + " Nombre: " + sub.getName()%></label></div>
                        <div>&nbsp;</div>
                        <div  class="text-center"><label><%= "Descripción: " + sub.getDescription()%></label></div>
                        <div>&nbsp;</div>
                        <div  class="text-center"><label><%= "Director: " + sub.getDirector()%></label></div>
                        <div  class="text-center"><label><%= "En taquilla: " + sub.getInBillboard()%></label></div>
                        <a class ="btn btn-outline-light container center_div w-75 p-1" href="#">
                            Comprar tiquete(s)
                        </a>
                    </div>


                    <% } %>
                </div>
                <% } else { %>
                <div class="text-white text-center">No se encontraron peliculas referentes al criterio de búsqueda</div>
                <% }%>
            </div>
        </div>
    </body>
</html>