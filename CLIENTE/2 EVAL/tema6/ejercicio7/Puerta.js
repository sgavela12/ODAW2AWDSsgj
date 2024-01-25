export class Puerta{
    constructor(planta,numero){
        this.planta = planta;
        this.numero = numero;
        this.propietario = "";
    }

    agregaPropietario(nombre){
        this.propietario = nombre
    }

    getNumero(){
        return this.numero
    }

    getPlanta(){
        return this.planta
    }

    getPropietario(){
        return this.propietario
    }

    
}