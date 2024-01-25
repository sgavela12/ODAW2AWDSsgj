
export class Persona{

constructor(nombre,apellidos,email,contraseña){
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.email = email;
    this.contraseña = contraseña;
}


muestraDatos(){
    return `nombre: ${this.nombre} <br>
    apellidos: ${this.apellidos} <br>
    email: ${this.email} \n <br>
    contraseña: ${this.contraseña} \n <br>
    
    `
}

getEmail(){
    return this.email;
}
}