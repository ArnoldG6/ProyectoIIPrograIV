<%-- 
    Document   : booking
    Created on : 20/06/2021, 10:45:53 PM
    Author     : Vic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>booking</title>
        <link rel="stylesheet" href="css/booking.css" />
        <link rel="stylesheet" type="text/css" href="css/estilo.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.12/css/all.css">         
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script> 
    </head>
    <body class=" bg-dark text-white">
        <div class="content">
            <label class="title">Seleccione una Película</label>
            <select id="film">
                <option value="3000">Shrek Tico<span class="price"> ₡ 3000.00</span></option>
                <option value="3000">Matrix <span class="price"> ₡ 3000.00</span></option>
                <option value="3000">UXIONO <span class="price"> ₡ 3000.00</span></option>
            </select>
        </div>
        <div class="cinemaInfo">
            <div class="seat info"></div>
            <small>Desocupado</small>

            <div class="seat info selezionata"></div>
            <small>Seleccionado</small>

            <div class="seat info occupata"></div>
            <small>Ocupado</small>
        </div>
        <div class="theatre">
            <div class="screenArea"><span> ERIGEI</span></div>
            <div class="theatreRows">
                <div class="row" id="1">
                    <div class="rowNumb" id="1"></div>
                    <div class="sedia" id="1"></div>
                    <div class="sedia" id="2"></div>
                    <div class="sedia" id="3"></div>
                    <div class="seatwheelChair" id="4"><img class="wheelChair" src="images/icons8-wheelchair-52.png" alt=""></div>
                    <div class="seatwheelChair" id="5"><img class="wheelChair" src="images/icons8-wheelchair-52.png" alt=""></div>
                    <div class="sedia" id="6"></div>
                    <div class="sedia" id="7"></div>
                    <div class="sedia" id="8"></div>
                    <div class="sedia" id="9"></div>
                    <div class="sedia" id="10"></div>
                </div>
                <div class="row" id="2">
                    <div class="rowNumb" id="2"></div>
                    <div class="sedia" id="1"></div>
                    <div class="sedia" id="2"></div>
                    <div class="sedia" id="3"></div>
                    <div class="sedia" id="4"></div>
                    <div class="sedia" id="5"></div>
                    <div class="sedia" id="6"></div>
                    <div class="sedia" id="7"></div>
                    <div class="sedia" id="8"></div>
                    <div class="sedia" id="9"></div>
                    <div class="sedia" id="10"></div>
                </div>
                <div class="row" id="3">
                    <div class="rowNumb" id="3"></div>
                    <div class="sedia" id="1"></div>
                    <div class="sedia" id="2"></div>
                    <div class="sedia" id="3"></div>
                    <div class="sedia" id="4"></div>
                    <div class="sedia" id="5"></div>
                    <div class="sedia" id="6"></div>
                    <div class="sedia" id="7"></div>
                    <div class="sedia" id="8"></div>
                    <div class="sedia" id="9"></div>
                    <div class="sedia" id="10"></div>
                </div>
                <div class="row" id="4">
                    <div class="rowNumb" id="4"></div>
                    <div class="sedia" id="1"></div>
                    <div class="sedia" id="2"></div>
                    <div class="sedia" id="3"></div>
                    <div class="sedia" id="4"></div>
                    <div class="sedia" id="5"></div>
                    <div class="sedia" id="6"></div>
                    <div class="sedia" id="7"></div>
                    <div class="sedia" id="8"></div>
                    <div class="sedia" id="9"></div>
                    <div class="sedia" id="10"></div>
                </div>
                <div class="row" id="5">
                    <div class="rowNumb" id="5"></div>
                    <div class="sedia" id="1"></div>
                    <div class="sedia" id="2"></div>
                    <div class="sedia" id="3"></div>
                    <div class="sedia" id="4"></div>
                    <div class="sedia" id="5"></div>
                    <div class="sedia" id="6"></div>
                    <div class="sedia" id="7"></div>
                    <div class="sedia" id="8"></div>
                    <div class="sedia" id="9"></div>
                    <div class="sedia" id="10"></div>
                </div>
            </div>
        </div>
        <div class="checkout">
            <div class="checkOutAreaOne">
                <span> Puesto (Asiento/Fila):</span>
                <div class="postoS"></div>
                <br>
                <div class="checkoutTotal">
                    <span> Asientos: </span> <span class="sedieTotale" id="asientostotales"> 0 </span>
                    <span> Total: </span> <span class="costo" id="costototal"> 0 </span>
                </div>

                <br>
            </div>

            <div class="checkOutAreaTwo">
                <!-- BACKEND ROUTE -->
                <form action="#" method="POST" id="purchaseForm2">
                    <script>
                        // Hide default stripe button
                        //document.getElementsByClassName('stripe-button-el')[0].style.display = 'none';
                    </script>


                    <button type="submit" class="btnAcquista" id="purchase2">Comprar</button>
                    <!-- <button onclick="createPDF()" id="button">Generar PDF</button> -->

                    <div class="input-group-prepend "></span></div>
                    <input class="form-control" placeholder="Tarjeta de credito o debito" type="text" id="tarjeta" name="tarjeta" value="" required>
                    <div class="invalid-feedback">Ingrese la tarjeta</div>

                </form>

            </div>
        </div>
        <div class="d-flex justify-content-center">
            <object type="text/html" data="Footer.html"></object>
        </div>
    </body>
</html>
