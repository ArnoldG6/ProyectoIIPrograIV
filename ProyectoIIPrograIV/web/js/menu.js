var menu=`
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="/ExamenPrograIV/loadMovies"><div>HOME</div></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu" >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="menu">
        <ul class="navbar-nav ml-auto" id="menuUl">
          <li class="nav-item">
            <a class="nav-link" href="/ExamenPrograIV/loadMovies">Contact us</a>
          </li>`;  
          
            let usuarioJson = sessionStorage.getItem('user');
            
            if (usuarioJson!==null){ 
                let usuario= JSON.parse(usuarioJson);
                if (['ADM', 'CLI'].includes(usuario.role)){
                    menu+=` 
                        <li class="nav-item">
                            <a class="nav-link" href="/ExamenPrograIV/booking.html">Book a Movie</a>
                        </li>`;
                    if(usuario.role == 'ADM'){
                        menu+=`
                        <li 
                           class='nav-item'> <a class='nav-link' href='/ExamenPrograIV/registerRoom.jsp'>Register Room</a> 
                        </li>
                        <li 
                           class='nav-item'> <a class='nav-link' href='#' data-toggle='modal' data-target='#registerMovieDialog'>Register Movie</a> 
                        </li>
                        <li 
                           class='nav-item'> <a class='nav-link' href='#' data-toggle='modal' data-target='#Dialog'>Pragramar Proyecciones</a> 
                        </li>
                        <li 
                           class='nav-item'> <a class='nav-link' href='#' data-toggle='modal' data-target='#Dialog'>Imprimir ticketes</a> 
                        </li>`;
                    }
                    if(usuario.role == 'CLI'){
                        menu+=`<li class='nav-item'> <a class='nav-link' href='listado.html'>Ver compras</a> </li>`;
                    }
                    
                }

                menu+=`
                    <li class='nav-item dropdown'>
                      <a class='nav-link dropdown-toggle' data-toggle='dropdown' href='#'> ${usuario.name}</a>
                      <div class='dropdown-menu'>
                        <a class='dropdown-item' id='logout'>Salir</a>
                      </div>
                    </li>
                    `;                
            }
            else{
              menu+=`
                <li class='nav-item'>
                    <a class='nav-link' href='#' data-toggle='modal' data-target='#loginDialog'>Login</a>
                </li>
                <li class='nav-item'>
                    <a class='nav-link' href='#' data-toggle='modal' data-target='#registerDialog'>Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ExamenPrograIV/booking.html">Book a Movie</a>
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