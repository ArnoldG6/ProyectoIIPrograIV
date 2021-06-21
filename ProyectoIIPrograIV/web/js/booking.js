/* global doc */
////******************************* SELECTIONS
// Git repo https://github.com/sitowebveloce/cinema-booking

const rows = document.querySelectorAll(".rows");
const costo = document.querySelector(".costo");
// Select seats total
let sedieTotale = document.querySelector(".sedieTotale");
let postoS = document.querySelector(".postoS");
// Select button
const acquista = document.querySelector(".btnAcquista");
// Select film selector
let film = document.getElementById("film");
// Select sedie
const sedie = document.querySelectorAll(".sedia:not(.occupata)");
// Global Variables
let removeSeat = false;
let seatRow = 0;
let seatNumber = 0;

// Select rows number and set the innerHtml value
let rowNumb = document.querySelectorAll(".rowNumb");
rowNumb.forEach(element => {
    element.innerHTML = `Fila ${element.id}`;
});

//******************* UPDATE VALUES FUNCTION */
const updateValues = (seatNumber, seatRow, removeSeat) => {
    // Select seats with class 'selezionata'
    let seatSelected = document.querySelectorAll(".row .sedia.selezionata");
    
    // Create array for localstorage
    let localStorageSeats = [...seatSelected].map(seat => {
        return [...sedie].indexOf(seat);
    });
    // Save seats selected inside browser localstorage
    localStorage.setItem("poltrone", JSON.stringify(localStorageSeats));

    // Populate info area
    if (seatNumber && seatRow !== undefined) {
        if (!removeSeat) {
            postoS.innerHTML += ` ${seatNumber}/${seatRow} -`;
            // Save value inside browser local storage
            localStorage.setItem("S&&F", postoS.innerHTML);
            
        } else {
            postoS.innerHTML = postoS.innerHTML.replace(
                    ` ${seatNumber}/${seatRow} -`,
                    ""
                    );
            
            // Save value inside browser local storage
            localStorage.setItem("S&&F", postoS.innerHTML);
        }
    }
    // Set ticket price
    let ticket = film.value;
    // Seats total number
    sedieTotale.innerHTML = seatSelected.length;
    // Price
    costo.innerHTML = seatSelected.length * ticket;
};

//************ Load data from browser local storage */
let sedieNotSelected = document.querySelectorAll(".sedia:not(.selezionata)");
const loadData = () => {
    // Load data from the browser
    let poltrone = JSON.parse(localStorage.getItem("poltrone"));
    let movie = localStorage.getItem("movie");
    let price = localStorage.getItem("price");
    let occupate = JSON.parse(localStorage.getItem("occupate"));

    // Set selected seats
    if (poltrone !== null && poltrone.length > 0) {
        sedie.forEach((poltrona, index) => {
            if (poltrone.indexOf(index) > -1) {
                poltrona.classList.add("selezionata");
            }
        });
    }
    // Set seats occupate
    if (occupate !== null && occupate.length > 0) {
        sedieNotSelected.forEach((poltrona, index) => {
            if (occupate.indexOf(index) > -1) {
                poltrona.classList.add("occupata");
            }
        });
    }

    // Set movie title
    let movieSavedIdx = localStorage.getItem("movie");
    if (movieSavedIdx !== null) {
        film.selectedIndex = movieSavedIdx;
    }

    // Update values
    updateValues();

    // Populate area info
    let seatsInfo = localStorage.getItem("S&&F");
    postoS.innerHTML = seatsInfo;
};
// Run load data
loadData();

//*************** Select sedie and add event listener */
const sedieReload = document.querySelectorAll(".sedia:not(.occupata");
sedieReload.forEach(element => {
    // Set seat number
    element.innerHTML = element.id;
    // Add event listener
    element.addEventListener("click", () => {
        seatRow = element.parentElement.id;
        seatNumber = element.id;

        // Add and remove color class
        if (element.classList.value == "sedia") {
            element.classList.add("selezionata");
            // Set false remove variable
            removeSeat = false;
            // Update values
            updateValues(seatNumber, seatRow, removeSeat);
        } else {
            element.classList.remove("selezionata");
            // Set true remove variable
            removeSeat = true;
            // Update values
            updateValues(seatNumber, seatRow, removeSeat);
        }
    });
});

//********************* Movie title event listener */
film.addEventListener("change", e => {
    // Ticket
    let ticket = parseInt(e.target.value);
    let movieTitle = e.target.selectedIndex;
    // Save inside localstorage movie title
    localStorage.setItem("movie", movieTitle);
    // Save price
    localStorage.setItem("price", ticket);
    // Update value
    updateValues();
});

//***************** BTN ACQUISTA EVENT LISTENER */
acquista.addEventListener("click", () => {
    let sedia = document.querySelectorAll(".sedia.selezionata");
    sedia.forEach(element => {
        element.classList.remove("selezionata");
        element.classList.add("occupata");
        // Clear all fields
        element.innerHTML = "";
        sedieTotale.innerHTML = "";
        costo.innerHTML = "";
        postoS.innerHTML = "";
        // Clear localStorage
        localStorage.clear();

        // Save inside local Storage
        let seatBusySelec = document.querySelectorAll(".row .sedia.occupata");

        const localStorageSeatsOccupied = [...seatBusySelec].map(seat => {
            return [...sedieNotSelected].indexOf(seat);
        });

        // Save
        localStorage.setItem("occupate", JSON.stringify(localStorageSeatsOccupied));
    });
});


function subStringAsientos() {

    var cadena = $("#asientostotales").val(),
            separador = " -",
            asientos = cadena.split(separador);
    console.log(asientos);
    for (var i = 0; i < asientos.length-1; i++){
        purchase(asientos[i]);
        console.log(asientos[i]);
    }


}

var url = "http://localhost:8080/ExamenPrograIV/";

function purchase(Asiento) {
    if (!valPurchase())
        return;
    ticketOffice = {
        id: Asiento,
        occupied: 1,
        total: $("#costototal").val()
    };
    console.log("Este es el ticketOffice" + ticketOffice);
    let request = new Request(url + 'api/purchase', {method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify((ticketOffice))});
    (async () => {
        const response = await fetch(request);
        //$('#purchaseDialog').modal('hide');
        document.location = url;

    })();
    var doc = new jsPDF();

    doc.text(10, 10, "Hola");

    doc.save("Compra.pdf");
}

function valPurchase() {
    $("#purchaseForm2").addClass("was-validated");
    return $("#purchaseForm2").get(0).checkValidity();
}
function errorMessage(status, place) {
    switch (status) {
        case 404:
            error = "Registro no encontrado";
            break;
        case 403:
        case 405:
            error = "Usuario no autorizado";
            break;
        case 406:
        case 405:
            error = "Usuario ya existe";
            break;
    }
    ;
    place.html('<div class="alert alert-danger fade show">' +
            '<button type="button" class="close" data-dismiss="alert">' +
            '&times;</button><h4 class="alert-heading">Error!</h4>' + error + '</div>');
    return;
}

function loadPurchase() {
    let request = new Request(url + 'booking.html', {method: 'GET'});
    (async () => {
        const response = await fetch(request);
        content = await response.text();
        $('body').append(content);
        $("#purchase2").click(purchase);
    })();

}

$(loadPurchase);

var csm = `
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#csm" >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="csm">
        <ul class="navbar-nav ml-auto" id="csmUl">`;

let usuarioJson = sessionStorage.getItem('user');

if (usuarioJson !== null) {
    let usuario = JSON.parse(usuarioJson);
    if (['ADM', 'CLI'].includes(usuario.role)) {
    }
    csm += `
                        <div class="input-group-prepend "><span class="input-group-text"><i class="fa fa-user bigicon"></i></span></div>
                            <input class="form-control" placeholder="Digite su nombre" type="text" id="NombreU" name="NombreU" value="" required>
                        <div class="invalid-feedback">Ingrese el nombre</div>
                        `;
} else {
}
csm += `
        </ul>
      </div>
    </div>
  </nav>`;

function loadBookingA() {
    $('body').prepend(csm);
}

$(loadBookingA);  