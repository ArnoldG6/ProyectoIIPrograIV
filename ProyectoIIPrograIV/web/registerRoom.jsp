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
    <body>
        <!-- REGISTER ROOM -->
        <div class="row">              
            <div class="modal fade" id="registerRoomDialog" tabindex="-1" role="dialog">
                <div class="modal-dialog" style="width: 400px">
                    <div class="modal-content">
                        <div class="modal-header" >
                            <div class="d-flex justify-content-center" style="width: 90%">  <img class="img-circle" id="img_logo" src="images/user.png" style="max-width: 50px; max-height: 50px"> </div>
                            <div> <button type="button" class="close" data-dismiss="modal"> <span aria-hidden="true">&times;</span> </button> </div>
                        </div>
                        <form id="registerRoomForm">
                            <div class="modal-body">
                                <div id="div-login-msg">
                                    <div id="icon-login-msg" ></div>
                                    <span>Registro de Salas</span>
                                </div>
                                <br>
                                <div class="input-group" style="margin-bottom: 25px">
                                    <div class="input-group-prepend "><span class="input-group-text"><i class="fa fa-user bigicon"></i></span></div>
                                    <input class="form-control" placeholder="Numero de Sala" type="text" id="room_id" name="room_id" value="" required>
                                    <div class="invalid-feedback">Ingrese el numero de la Sala</div>
                                </div>                    
                            </div>
                            <div class="modal-footer d-flex justify-content-center">
                                <div>
                                    <button type="button" id="registerRoom" class="btn btn-primary btn-lg btn-block">Registrar Sala</button>
                                </div>
                            </div>
                            <div id="r_errorDiv" style="width:80%; margin: auto;"></div>     
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
