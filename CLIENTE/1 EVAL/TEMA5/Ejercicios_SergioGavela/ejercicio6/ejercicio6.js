let botones =[]
let boton1 =[document.getElementById("button1"),"img/coche.jpg",false,false]
let boton2 =[document.getElementById("button2"),"img/vaca.jpg",false,false]
let boton3 =[document.getElementById("button3"),"img/perro.jpg",false,false]
let boton4 =[document.getElementById("button4"),"img/coche.jpg",false,false]
let boton5 =[document.getElementById("button5"),"img/perro.jpg",false,false]
let boton6 =[document.getElementById("button6"),"img/mike.jpg",false,false]
let boton7 =[document.getElementById("button7"),"img/hasbu.jpg",false,false]
let boton8 =[document.getElementById("button8"),"img/bici.jpg",false,false]
let boton9 =[document.getElementById("button9"),"img/vaca.jpg",false,false]
let boton10 =[document.getElementById("button10"),"img/bici.jpg",false,false]
let boton11 =[document.getElementById("button11"),"img/mike.jpg",false,false]
let boton12 =[document.getElementById("button12"),"img/hasbu.jpg",false,false]
let numeroAciertos = document.getElementById("numeroAciertos")
let mensajeGanado = document.getElementById("mensajeGanado")
let numeroErrores = document.getElementById("numeroErrores")
let nombre = document.getElementById("nombre")
let formularioNombre=document.getElementById("formularioNombre")
let juego = document.getElementById("juego")
let aceptarNombreBoton = document.fgetElementById("aceptarNombre")
let mensajeNombre = document.getElementById("mensajeNombre")
let vecesJugadas = document.getElementById("vecesJugadas")
let restart = document.getElementById("restart")

let imagenesVolteadas = 0
let puntos = 0
let errores = 0
let primerBoton

aceptarNombre.addEventListener("click",()=>{
    document.cookie=`nombre=${nombre.value};`
    document.cookie=`contador=0`
})



if(!(document.cookie == "")){
    setCookie("contador",parseInt(getCookie("contador"))+1)
    vecesJugadas.innerHTML="Has jugado "+getCookie("contador")+" veces."
    restart.style.display="block"
    formularioNombre.style.display="none"
    juego.style.display="block"
    mensajeNombre.innerHTML="Bienvenido "+ getCookie("nombre")+"!"
}

restart.addEventListener("click",()=>{location.reload()})

botones.push(boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,boton10,boton11,boton12)

botones.forEach((boton)=>{
    boton[0].addEventListener("click",()=>{
        if(boton[2] == false && (imagenesVolteadas==0 || imagenesVolteadas==1) ){
            cambiaImagen(boton[0],boton[1])
            boton[2] = true
            imagenesVolteadas++
        }
        
        
    })
})

document.addEventListener("click",(()=>{
    checkImagenesVolteadas()
    actualizaErrores()
    checkAciertos()
    
}))


function setCookie(nombre, valor){
    document.cookie = nombre+"="+valor+";"
}


function getCookie(nombre){
    var nom = nombre+"=";
            var array = document.cookie.split(";");
            for (var i=0; i<array.length; i++){
                var c = array[i];
                while (c.charAt(0)==" "){
                    c = c.substring(1);
                }
                if (c.indexOf(nombre)==0){
                    return c.substring(nom.length, c.length);
                }
            }
            return "";
}



function esconderImagenes(){
    botones.forEach((boton)=>{
        if(boton[2]==true && boton[3]==false){
            boton[2]=false
            cambiaImagen(boton[0],"img/carta.jpg")
        }
    })
    
}

function actualizaAciertos(){
    numeroAciertos.innerHTML = `Numero de Aciertos: ${puntos}`
}

function actualizaErrores(){
    numeroErrores.innerHTML = `Numero de Errores: ${errores}`
}


function cambiaImagen(elemento,imagen){
    
    elemento.childNodes[0].setAttribute("src", imagen);
}

function checkAciertos(){
    if (puntos== 6){
        mensajeGanado.innerHTML="HAS GANADO!"
    }else{
        actualizaAciertos()
    }
}

function checkImagenesVolteadas(){
    let acierto = false
    if(imagenesVolteadas==1){
        botones.forEach((boton)=>{
            if(boton[2]==true && boton[3]== false){
                primerBoton = boton
            }
        })
    }
    if(imagenesVolteadas>=2){
        let coincidencias = 0
        botones.forEach((boton)=>{
            
            if(boton[2]==true){
                
            
            if(primerBoton[1] == boton[1]){
                coincidencias++
                if(coincidencias==2){
                    puntos++
                    acierto = true
                    primerBoton[3]=true
                    boton[3]=true
                    imagenesVolteadas =0
                }
               
                
            }
            }
        })
        if(!acierto){
            errores++
            setTimeout(()=>{
                esconderImagenes()
                imagenesVolteadas=0

            },1250)

        }
        acierto = false
       
    }
    
    
}