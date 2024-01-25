let eleccion = parseInt( prompt("Elije entre: \n 1.Potencia \n 2.Raiz \n 3.Redondeo \n 4.Trigonometria"));

switch (eleccion) {
    case 1:
        potencia();
        break;
    case 2:
        raiz();
        break;
    case 3:
        redondeo();
        break;
    case 4:
        trigonometria();
        break;

    default:
        alert("Numero no valido");
        break;
}


function potencia(){
    base = prompt("Introduce una base");
    exponente = prompt("Introduce un exponente");
    alert( Math.pow(base,exponente))
}


function raiz(){
    numero = prompt("Introduce un numero(no negativo)");
    alert("La raiz de " + numero+" es " + Math.sqrt(numero))
}


function redondeo(){
    numero = prompt("Introduce un numero");
    alert(numero +" redondeado es "+ Math.round(numero));
}

function trigonometria(){
    let angulo  = prompt("Introduce un angulo entre 0 y 360")
    alert( "El seno es "+ Math.round(Math.sin(angulo)*100)/100 + " el coseno es "+ Math.round(Math.cos(angulo)*100)/100+ " la tangente es "+Math.round( Math.tan(angulo)*100)/100)
}