var menu=`
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="#"><div>Home </div></a>
      <div class="navbar-brand" id="menu">
        <ul class="navbar-nav ml-auto" id="menuUl">
          <li class="nav-item">
            <a class="nav-link" href="#">Contact us</a>           
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Register</a>
          </li>`;
         

          
            let usuarioJson = sessionStorage.getItem('user');
            
            if (usuarioJson!=null){ 
                let usuario= JSON.parse(usuarioJson);
                if (['ADM','CLI'].includes(usuario.rol)){
                    menu+=`<li class='nav-item'> <a class='nav-link' href='listado.html'>Listado</a> </li>`;
                }

                menu+=`
                    <li class='nav-item dropdown'>
                      <a class='nav-link dropdown-toggle' data-toggle='dropdown' href='#'> ${usuario.nombre}</a>
                      <div class='dropdown-menu'>
                        <a class='dropdown-item' id='logout'>Salir</a>
                      </div>
                    </li>`;                
            }
            else{
              menu+=`
                <li class='nav-item'>
                    <a class='nav-link' href='' data-toggle='modal' data-target='#loginDialog'>Login</a>
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

