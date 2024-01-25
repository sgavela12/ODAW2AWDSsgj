let nombreCompleto = prompt("Introduzca su nombre y apellidos")
let nombreSeparado = nombreCompleto.split(" ");

muestraTamaño();
muestraMinusculas();
muestraMayusculas();
divideNombre();
propuesta();
propuesta2();

function muestraTamaño(){
    let numeroCaracteres = 0;
    nombreSeparado.forEach(palabra=>{
        numeroCaracteres += palabra.length;
    })
    document.write("El numero de caracteres sin contar espacios es: "+numeroCaracteres)
}

function muestraMinusculas(){
    document.write("<br> El nombre completo en minusculas es  "+ nombreCompleto.toLowerCase())
   
}

function muestraMayusculas(){
    document.write("<br> El nombre completo en mayusculas es  "+ nombreCompleto.toUpperCase())
   
}

function divideNombre(){
    document.write("<br> Nombre:"+nombreSeparado[0]+"<br> Apellido1: "+ nombreSeparado[1]+"<br>Apellido2: "+nombreSeparado[2])
}

function propuesta(){
    document.write("<br> Sugerencia de nombre de usuario: "+ nombreSeparado[0].charAt(0)+ nombreSeparado[1]+nombreSeparado[2].charAt(0))
}

function propuesta2(){
    document.write("<br> Otra sugerencia de nombre de usuario: "+ nombreSeparado[0].substring(0,3)+ nombreSeparado[1].substring(0,3)+nombreSeparado[2].substring(0,3))
}