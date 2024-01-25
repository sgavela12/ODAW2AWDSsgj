let radio = prompt("Introduce el valor del radio");

imprimeValores()
 
function imprimeValores(){
    document.write("El radio es "+ radio +"cm <br> El diametro "+ diametro()+ " cm <br> El perimetro es "+ perimetro()+ " cm <br> El area es "+ area()+ " cm2 <br> El area de la esfera "+ areaEsfera()+ " cm 2 <br> El volumen de la esfera "+ volumenEsfera() +"cm3")

}

function diametro(){
    return radio *2;
}
function perimetro(){
   return 2 * Math.PI * radio; 
}

function area(){
    return Math.PI * (radio)^2;
}

function areaEsfera(){
    return 4*Math.PI *(radio)^2;
}

function volumenEsfera(){
    return 4/3 * Math.PI * (radio)^3;
}