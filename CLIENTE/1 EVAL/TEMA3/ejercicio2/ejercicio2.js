let dia = prompt("Introduce el dia de tu cumpleaños");
let mes = prompt("Introduce el numero de mes de tu cumpleaños");
let ano = 2023;
let numeroDomingos = 0;

let fecha = new Date(`${ano}-${mes}-${dia}`)

for(;fecha.getFullYear()<=2100;fecha.setFullYear(fecha.getFullYear()+1)){
    if(fecha.getDay()==0){
        
        numeroDomingos++;
    }
}

alert("El numero de cumpleaños que van a caer en domingo son "+ numeroDomingos);