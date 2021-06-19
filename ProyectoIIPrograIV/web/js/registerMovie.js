var url="http://localhost:8080/ExamenPrograIV/";

    function registerMovie(){
        if (!valRegisterMovie()) return;
        movie = {
            id: $("#m_id").val(),
            name: $("#m_name").val(),
            description: $("#m_desc").val(),
            publicationYear: $("#m_year").val(),
            director: $("#m_dir").val(),
            imgLink: $("#m_img_link").val()
        };       
        console.log(movie);
        let request = new Request(url+'api/registerMovie', {method: 'POST', headers: { 'Content-Type': 'application/json'},body: JSON.stringify((movie))});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#registerMovieDialog #r_errorDiv"));return;}
            $('#registerMovieDialog').modal('hide');
            document.location = url;
            
        })(); 
    }

    function valRegisterMovie(){
        $("#registerMovieForm").addClass("was-validated");
        return $("#registerMovieForm").get(0).checkValidity(); 
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
  
  function loadRegisterMovie(){
        let request = new Request(url+'registerMovie.html', {method: 'GET'});
        (async ()=>{
            const response = await fetch(request);
            if (!response.ok) {errorMessage(response.status,$("#registerMovieDialog #r_errorDiv"));return;}
            content = await response.text();
            $('body').append(content); 
            $("#registerMovie").click(registerMovie);                         
        })();     
  }
  
  $(loadRegisterMovie);  


