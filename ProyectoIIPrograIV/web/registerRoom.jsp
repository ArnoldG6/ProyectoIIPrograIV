<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilo.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css">         
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        
        <title>Register Room</title>
    </head>
    <body class=" bg-dark text-white">
        <h1 class = "text-center">Registrar una Sala</h1>

        <form class = "container center_div w-75 p-3" name = "regForm" action="/ProyectoIIPrograIV/registerRoom" method="POST">
            <div class = "form-group">
                <label for = "regId">Número de identificación</label>
                <input type="text" class ="form-control  text-center" name = "room_id" placeholder = "Número de Sala" id = "room_id">
                <div class="text-center">
                <div>&nbsp;</div>
                <div>&nbsp;</div>
                <button class ="btn btn-outline-light form-control w-50">Completar registro</button>
                </div>
            </div>
        </form> 

    </body>
</html>
