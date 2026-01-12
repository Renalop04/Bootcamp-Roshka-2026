//Botones de paginas
const boton_jugar = document.getElementById("Bot_jugar");
const modo_juego = document.getElementById("modo_juego");
const juego = document.getElementById("juego");

//Modo de juego
const boton_un_jugador = document.getElementById("un_jugador");
const boton_dos_jugadores = document.getElementById("dos_jugadores");

//reiniciar
const btnReiniciar = document.getElementById("btn_reiniciar");
const info = document.getElementById("resultado_partida");


//
const pantalla_nombres = document.getElementById("pantalla_nombres");
const nombre_x = document.getElementById("nombre_X");
const nombre_o = document.getElementById("nombre_Y");
const contenedor_o = document.getElementById("contenedor_input_o");
const btn_comenzar = document.getElementById("btn_comenzar");
const cabecera_titulo = document.getElementById("cabecera_titulo");
const menu = document.getElementById("menu");

let nombre_jugadorX = " ";
let nombre_jugadorY = " ";
let modoSeleccionado = 0;

boton_jugar.addEventListener("click", function () {
    boton_jugar.style.display = "none";
    modo_juego.style.display = "flex";
});

boton_un_jugador.addEventListener("click", function() {
    modoSeleccionado = 1;
    modo_juego.style.display = "none";
    pantalla_nombres.style.display = "block";
    contenedor_o.style.display = "none"; // X
});

boton_dos_jugadores.addEventListener("click", function () {
    modoSeleccionado = 2;
    modo_juego.style.display = "none";
    pantalla_nombres.style.display = "block"; // X
    contenedor_o.style.display = "block"; // Y
});

btn_comenzar.addEventListener("click", function() {
    const val_x = nombre_x.value.trim();
    const val_o = nombre_o.value.trim();

    if (modoSeleccionado === 1) {
        if (val_x !== "") {
            nombre_jugadorX = val_x;
            nombre_jugadorY = "a la toda poderosa ia";
            iniciarTablero();
        } else {
            alert("Por favor ingresa el nombre de x correcto");
        }
    } 
    else if (modoSeleccionado === 2) {
        if (val_x !== "" && val_o !== "") {
            nombre_jugadorX = val_x;
            nombre_jugadorY = val_o;
            iniciarTablero();
        } else {
            alert("Ambos jugadores deben tener un nombre correcto");
        }
    }
});

function iniciarTablero() {
    pantalla_nombres.style.display = "none";
    cabecera_titulo.style.display = "none";
    juego.style.display = "block";
    btnReiniciar.style.display = "none";
    console.log("Tablero listo");
    const info = document.getElementById("resultado_partida");
    info.innerText = "Turno de: " + nombre_jugadorX + " (X)";
}

//juego_de_verdad//
const Tablero = ["","","","","","","","",""];
const celdas = document.querySelectorAll(".celda");
let turno = 0; 
function turno_actual(){
    if( turno % 2 == 0){
        return "x";
    }else{
        return "o";
    }
}

function revisarGanador() {
    const combinaciones = [
        [0,1,2],
        [3,4,5],
        [6,7,8],
        [0,3,6],
        [1,4,7],
        [2,5,8],
        [0,4,8],
        [2,4,6]
    ];

    for (let i = 0; i < combinaciones.length; i++) {
        const [a,b,c] = combinaciones[i];
        if (Tablero[a] !== "" && Tablero[a] === Tablero[b] && Tablero[a] === Tablero[c]) {

            celdas[a].style.backgroundColor = "black";
            celdas[b].style.backgroundColor = "black";
            celdas[c].style.backgroundColor = "black";
            return Tablero[a]; // devuelve X o O
            
        }
    }

    return null; //nadie gano tdv
}

function nombreDelJugador(simbolo) {
    if (simbolo === "x") {
        return nombre_jugadorX;
    } else {
        return nombre_jugadorY;
    }
}

for(let i = 0 ; i < celdas.length ; i++){
    celdas[i].addEventListener("click", function(){
        if (Tablero[i] === ""){
            const jugador = turno_actual();
            Tablero[i] = jugador;
            celdas[i].innerText = jugador;
            turno++;

            const ganador = revisarGanador();
            
            if (ganador){
                info.innerText = "Felicidades " + nombreDelJugador(ganador);
                for(let j = 0 ; j < celdas.length ; j++){
                    celdas[j].style.pointerEvents = "none";
                }
                btnReiniciar.style.display = "block";
                menu.style.display = "block";
                return; 
            }
            
            if(revisarEmpate()){
                info.innerText = "Empate";
                btnReiniciar.style.display = "block";
                menu.style.display = "block";
                return; 
            }
            
            info.innerText = "Turno de: " + nombreDelJugador(turno_actual());
            
            if (modoSeleccionado === 1 && turno_actual() === "o") {
                jugarIA(); 
            }
        }
    });
}

function revisarEmpate() {
    return Tablero.every(celda => celda !== ""); 
}

function jugarIA(){
    const vacias = [];
    for (let i = 0; i < Tablero.length; i++){
        if (Tablero[i] === "") {
            vacias.push(i);
        }
    }

    if (vacias.length === 0) return;

    // Escoger una al azar
    const index = vacias[Math.floor(Math.random() * vacias.length)];

    // Jugar
    Tablero[index] = "o";
    celdas[index].innerText = "o";
    turno++;

    // Revisar ganador después de la IA
    const ganador = revisarGanador();
    const info = document.getElementById("resultado_partida");

    if (ganador) {
        info.innerText = "Felicidades " + nombreDelJugador(ganador);
        for (let j = 0; j < celdas.length; j++) {
            celdas[j].style.pointerEvents = "none";
        }
        btnReiniciar.style.display = "block";
        menu.style.display = "block";
    } else if (revisarEmpate()) {
        info.innerText = "Empate";
        btnReiniciar.style.display = "block";
        menu.style.display = "block";
    } else {
        info.innerText = "Turno de: " + nombreDelJugador(turno_actual());
    }
}

/*boton de reiniciar*/

function reiniciar(){
    for ( let i = 0 ; i < Tablero.length ; i++){
        Tablero[i] = ""
    }

    for (let i = 0; i < celdas.length; i++) {
        celdas[i].innerText = "";
        celdas[i].style.pointerEvents = "auto";
        celdas[i].style.color = "black";
        celdas[i].style.backgroundColor = "white";
    }

    turno = 0;

    document.getElementById("resultado_partida").innerText = "Turno de X";
}

btnReiniciar.addEventListener("click",reiniciar);

/*Boton de menu*/
function volverMenu(){
    /*reinicio de partida*/
    for ( let i = 0 ; i < Tablero.length ; i++){
        Tablero[i] = ""
    }

    for (let i = 0; i < celdas.length; i++) {
        celdas[i].innerText = "";
        celdas[i].style.pointerEvents = "auto";
        celdas[i].style.color = "black";
        celdas[i].style.backgroundColor = "white";
    }

    turno = 0;

    /*reinicio de nombres*/
    nombre_x.value = "";
    nombre_o.value = "";

    /*ocultar menus etc*/
    juego.style.display = "none";
    menu.style.display = "none";
    btnReiniciar.style.display = "none";
    cabecera_titulo.style.display = "flex";
    boton_jugar.style.display = "flex";
}
menu.addEventListener("click",volverMenu)

