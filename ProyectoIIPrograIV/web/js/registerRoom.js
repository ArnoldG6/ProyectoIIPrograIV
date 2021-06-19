var url="http://localhost:8080/ExamenPrograIV/";
                                
    function registerRoom(){
        if (!valRoomRegister()) return;
        room = {id: $("#room_id").val()};       
        console.log(room);
        let request = new Request(url+'api/registerRoom', {method: 'POST', headers: { 'Content-Type': 'application/json'},body: JSON.stringify(room)});
        (async ()=>{
            console.log("wea 1");
            const response = await fetch(request);
            console.log("wea 2");
            if (!response.ok) {errorMessage(response.status,$("#registerRoomDialog #r_errorDiv"));return;}
            console.log("wea 3");
            $('#registerRoomDialog').modal('hide');
            console.log("wea 4");
            document.location = url;
            console.log("wea 5");
            
        })(); 
    }

    function valRoomRegister(){
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
  
  function loadRoomRegister(){
        let request = new Request(url+'registerRoom.html', {method: 'GET'});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#registerRoomDialog #r_errorDiv"));return;}
            content = await response.text();
            $('body').append(content); 
            $("#registerRoom").click(registerRoom);                         
        })();     
  }
  
  $(loadRoomRegister); 

