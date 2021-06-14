var menu=`
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="#"><div>HOME</div></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu" >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="menu">
        <ul class="navbar-nav ml-auto" id="menuUl">
          <li class="nav-item">
            <a class="nav-link" href="#">Contact Us</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Register</a>
          </li>`;        
         
         

          
            let userJson = sessionStorage.getItem('user');
            
            if (userJson!=null){ 
                let user= JSON.parse(userJson);
                if (['ADM','CLI'].includes(user.role)){
                    menu+=`<li class='nav-item'> <a class='nav-link' href='Presentation/MyMovies.html'>My Movies</a></li>`;
                }

                menu+=`
                    <li class='nav-item dropdown'>
                      <a class='nav-link dropdown-toggle' data-toggle='dropdown' href='#'> ${user.username}</a>
                      <div class='dropdown-menu'>
                        <a class='dropdown-item' id='logout'>Salir</a>
                      </div>
                    </li>`;                
            }
            else{
              menu+=`
                <li class='nav-item'>
                    <a class='nav-link' href='#' data-toggle='modal' data-target='#loginDialog'>Login</a>
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

