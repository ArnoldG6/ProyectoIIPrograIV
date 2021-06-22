var url="http://localhost:8080/ExamenPrograIV/";
    function load(){  
        let request = new Request(url+'api/loadMovies', {method: 'POST', headers: { }});
        (async ()=>{
            console.log("hola 1");
            const response = await fetch(request);
            console.log("hola 2");
            //if (!response.ok) {errorMessage(response.status,$("#loginDialog #errorDiv"));return;}
            let billboards = sessionStorage.getItem('billboards');           
            console.log(billboards);
            console.log("hola 3");
        })(); 
    }
  function errorMessage(status,place){  
      console.log("hola errormsessage");
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
  function loadMovies(){
      console.log("hola loadMovies 1");
        let request = new Request(url+'login.html', {method: 'GET'});
        (async ()=>{
            console.log("hola loadMovies 2");
            const response = await fetch(request);
            console.log("hola loadMovies 3");
            //if (!response.ok) {errorMessage(response.status,$("#loginDialog #errorDiv"));return;}
            console.log("hola loadMovies 4");
            load();
            console.log("hola loadMovies 5")
            content = await response.text();
            console.log("hola loadMovies 6");
            $('body').append(content); 
            console.log("hola loadMovies 7");
  
        })();     
  }
 
  $(loadMovies);  
