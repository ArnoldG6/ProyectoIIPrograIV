var url="http://localhost:8080/ExamenPrograIV/";

    function registerRoom(){
        if (!valRegisterRoom()) return;
        room = {
            id: $("#r_id").val()
        };       
        console.log(room);
        let request = new Request(url+'api/registerRoom', {method: 'POST', headers: { 'Content-Type': 'application/json'},body: JSON.stringify((room))});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#registerRoomDialog #r_errorDiv"));return;}
            $('#registerRoomDialog').modal('hide');
            document.location = url;
            
        })(); 
    }

    function valRegisterRoom(){
        $("#registerRoomForm").addClass("was-validated");
        return $("#registerRoomForm").get(0).checkValidity(); 
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
  
  function loadRegisterRoom(){
        let request = new Request(url+'registerRoom.html', {method: 'GET'});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#registerRoomDialog #r_errorDiv"));return;}
            content = await response.text();
            $('body').append(content); 
            $("#registerRoom").click(registerRoom);                         
        })();     
  }
  
  $(loadRegisterRoom);  