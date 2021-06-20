 /* global doc */

var url="http://localhost:8080/ExamenPrograIV/";

    function purchase(){
        if (!valPurchase()) return;
        ticketOffice = {
            id: $("#Asietnos").val()
        };       
        console.log(ticketOffice);
        let request = new Request(url+'api/purchase', {method: 'POST', headers: { 'Content-Type': 'application/json'},body: JSON.stringify((ticketOffice))});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#purchaseDialog #r_errorDiv"));return;}
            $('#purchaseDialog').modal('hide');
            document.location = url;
            
        })(); 
    }

    function valPurchase(){
        $("#purchaseForm").addClass("was-validated");
        return $("#purchaseForm").get(0).checkValidity(); 
    }
  function errorMessage(status,place){  
        switch(status){
            case 404: error= "Registro no encontrado"; break;
            case 403: case 405: error="Usuario no autorizado"; break;
            case 406: case 405: error="Usuario ya existe"; break;
        };            
        place.html('<div class="alert alert-danger fade show">' +
        '<button type="button" class="close" data-dismiss="alert">' +
        '&times;</button><h4 class="alert-heading">Error!</h4>'+error+'</div>');
        return;        
    }  
  
  function loadPurchase(){
        let request = new Request(url+'index.html', {method: 'GET'});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#purchaseDialog #r_errorDiv"));return;}
            content = await response.text();
            $('body').append(content); 
            $("#purchase").click(purchase);                         
        })();
        var doc = new jsPDF();
        
        doc.text(10,10,"Hola");

        doc.save("Compra.pdf");
  }
  
  $(loadPurchase);