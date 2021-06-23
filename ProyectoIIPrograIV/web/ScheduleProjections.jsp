<%@page import="java.util.Map"%>
<%@page import="model.Movie"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User usua = (User) session.getAttribute("user");%>
<%HashMap<String, Movie> movs = (HashMap<String, Movie>) session.getAttribute("movs");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Projections</title>
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

        <form class = "container center_div w-75 p-3" name = "regForm" action="/ExamenPrograIV/schedule" method="POST">
            <div class = "form-group">
                <H1 class = "text-center text-white">Registro de proyecciones</H1>
                <div>&nbsp;</div>
                <% if (movs != null) { %>
                <select name="newBillboard" id = "newBillboard" class ="form-control text-center">
                    <option value="" selected>Seleccione una pelicula</option>
                    <%for (Map.Entry<String, Movie> entry : movs.entrySet()) { %>
                    <% Movie s = movs.get(entry.getKey());%>
                    <option value = "<%= s.getId()%>" > <%= s.getId()+"/"+s.getName()+"/"+s.getDirector()+"/"+s.getPublicationYear()%> </option>
                    <% }%>
                    
                </select>
                <div>&nbsp;</div> 
                <div>&nbsp;</div> 
                <div>&nbsp;</div> 
                <div class = "text-center">
                <a href="/ExamenPrograIV/PutIn" id="imagen1" class="p-3 bg-dark text-center" >
                        <button class ="btn btn-outline-light form-control w-50" id = "agregar">Agregar a taquilla</button>
                </a>
                </div>   
                <div>&nbsp;</div>
                <div class = "text-center">
                <a  href="/ExamenPrograIV/GetOff" id="imagen1" class="p-3 bg-dark text-center" >
                    
                        <button class ="btn btn-outline-light form-control w-50" id = "agregar">Remover de taquilla</button>
                </a>
                </div>    
                <% } else {%>
                <div class="text-white text-center">No hay peliculas disponibles para proyectar</div>
                <% }%>
                <div>

                </div>
            </div>
        </form>

        <div class="d-flex justify-content-center">
            <object type="text/html" data="Footer.html"></object>
        </div>
    </body>
</html>
