let numero =Number.parseInt( prompt("Introduzca un numero"));
let body = document.querySelector("body");



exponencial()
decimales();
binario();
octal();
hexadeciaml();


function exponencial(){
    let n = numero.toExponential();
    document.write("El Valor exponencial de "+ numero +" es "+ n)
}


function decimales(){
    let n =numero.toFixed(4);
    document.write("<br> El  decimal de  "+ numero +" es "+ n)
}

function binario(){
    let n = numero.toString(2)
    document.write("<br> El valor binario de  "+ numero +" es "+ n)
}

function octal(){
    let n = numero.toString(8)
    document.write("<br> El valor octal de  "+ numero +" es "+ n)
}

function hexadeciaml(){
    let n = numero.toString(16)
    document.write("<br> El valor hexadecimal de  "+ numero +" es "+ n)
}