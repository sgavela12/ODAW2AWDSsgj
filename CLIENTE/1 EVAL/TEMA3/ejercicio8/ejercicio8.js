let input = prompt("Introduce nombre:apellidos:telefono:email:codigopostal");
let valoresSeparados = input.split(":");


document.write("Codigo postal: "+ valoresSeparados[4]);
document.write("<br>Apellidos: "+ valoresSeparados[1]);
document.write("<br>Email: "+ valoresSeparados[3]);
document.write("<br>Servidor mail: "+ valoresSeparados[3].split("@")[1]);
document.write("<br>Telefono "+ valoresSeparados[2]);