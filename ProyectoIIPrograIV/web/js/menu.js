var menu=`
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="/ExamenPrograIV/loadMovies"><div></div>
        <img src="images/house.png" height="60" width = "60">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu" >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="menu">
        <ul class="navbar-nav ml-auto" id="menuUl">`;  
          
            let usuarioJson = sessionStorage.getItem('user');
            
            if (usuarioJson!==null){ 
                let usuario= JSON.parse(usuarioJson);
                if (['ADM', 'CLI'].includes(usuario.role)){
                    menu+=` 
                        <li class="nav-item">
                            <a class="nav-link" href="/ExamenPrograIV/booking.html">Comprar un tiquete</a>
                        </li>`;
                    if(usuario.role == 'ADM'){
                        menu+=`
                        <li 
                           class='nav-item'> <a class='nav-link' href='/ExamenPrograIV/registerRoom.jsp'>Registrar una sala</a> 
                        </li>
                        <li 
                           class='nav-item'> <a class='nav-link' href='#' data-toggle='modal' data-target='#registerMovieDialog'>Ingresar pelicula</a> 
                        </li>
                        <li 
                           class='nav-item'> <a class='nav-link' href='/ExamenPrograIV/schedule'>Programar Proyecciones</a> 
                        </li>
                        <li 
                           class='nav-item'> <a class='nav-link' href='#' data-toggle='modal' data-target='#Dialog'>Imprimir Tiquetes</a> 
                        </li>`;
                    }
                    if(usuario.role == 'CLI'){
                        menu+=`<li class='nav-item'> <a class='nav-link' href='/ExamenPrograIV/seePurchases'>Ver compras</a> </li>`;
                    }
                    
                }

                menu+=`
                    <li class='nav-item dropdown'>
                      <a class='nav-link dropdown-toggle' data-toggle='dropdown' href='#'> ${usuario.name}</a>
                      <div class='dropdown-menu'>
                        <a class='dropdown-item' id='logout'>Cerrar sesion</a>
                      </div>
                    </li>
                    `;                
            }
            else{
              menu+=`
                <li class='nav-item'>
                    <a class='nav-link' href='#' data-toggle='modal' data-target='#loginDialog'>Ingresar</a>
                </li>
                <li class='nav-item'>
                    <a class='nav-link' href='#' data-toggle='modal' data-target='#registerDialog'>Registrar</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ExamenPrograIV/booking.html">Comprar un tiquete</a>
                </li>`;           
            }
            menu+=`
        </ul>
      </div>
    </div>
  </nav>`;
  
  function loadMenu(){
    $('body').prepend(menu); 
  }
  
  $(loadMenu);  