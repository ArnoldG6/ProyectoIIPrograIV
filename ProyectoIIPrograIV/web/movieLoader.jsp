<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="model.Movie"%>
<%HashMap<String, Movie> billboards = (HashMap<String, Movie>) session.getAttribute("billboards"); %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>NGC Cinema</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <link rel="icon" href="data:;base64,=">
    </head>
    <body class="d-flex flex-column min-vh-100 bg-dark text-white">
        <!--
        <div align='center' class="w-200 p-10 bg-dark">
            <form name = "form" class = "container center_div w-75 p-3" action="/ProyectoI/presentation/subjects/search" method="post">
                <input  class = "container center_div w-75 p-1 text-center" type="text" name="searchCriteria" id = "searchCriteria" placeholder="Nombre, código o descripción del curso" >
                <div>&nbsp;</div>
            </form> 
        </div>
        -->
        <div class="container">

            <% if (billboards != null) { %>
            <h1 class="text-white text-center">Taquilla</h1>
            <div class="row p-1 bg-dark column card-body w-15">
                <%for (HashMap.Entry<String, Movie> entry : billboards.entrySet()) { %>   
                <% Movie sub = billboards.get(entry.getKey());%>


                <div class="card p-3 bg-dark col w-15">
                    <a href="#" id="imagen1" class="p-3 bg-dark text-center" >
                        <img src='<%=sub.getImgLink()%>' height="150" width = "150">
                    </a>
                    <div><label class="card-title text-center"><%= sub.getId()+"-"+sub.getName()%></label></div>
                    <div>&nbsp;</div>
                    <div><label class="text-center"><%= sub.getDescription()%></label></div>
                    <div>&nbsp;</div>
                    <div><label class="text-center"><%= sub.getDirector()%></label></div>
                    <a class ="btn btn-outline-light container center_div w-75 p-1" href="#">
                        Comprar tiquete(s)
                    </a>
                </div>


                <% } %>

            </div>
            <% } else { %>
            <div class="text-white text-center"></div>
            <% }%>
        </div>
    </body>
</html>