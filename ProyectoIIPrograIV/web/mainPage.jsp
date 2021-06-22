<!DOCTYPE html>
<html>
    <head>
         <meta charset="UTF-8">
        <title>NGC Cinema</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css">         
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
        <script src="js/register.js"></script>
        <script src="js/menu.js"></script>
        <script src="js/login.js"></script>
        <script src="js/booking.js"></script>
        <link rel="icon" href="/ExamenPrograIV/images/landing-page.png" >
    </head>
    <body class=" bg-dark text-white">
        <div class="p-3 bg-dark border w-90 mx-auto">
            <h4 class="card-title mt-3 text-center">NGC Cinema</h4> 
            <img class="w-100 mx-auto" src="images/csm.png" height="250" width = "800">
        </div>
        <%@ include file="/movieLoader.jsp" %>
        <div class="d-flex justify-content-center">
            <object type="text/html" data="Footer.html"></object>
        </div>
    </body>
    
    
</html>
