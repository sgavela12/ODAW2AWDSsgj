export class Cliente{
    constructor(tipo,numero,fecha,){
        this.tipo = tipo;
        this.numero = numero;
        this.fecha = fecha;
        
    }
    getTipo() {
        return this.tipo;
    }

    getNumero() {
        return this.numero;
    }

    getFecha() {
        return this.fecha;
    }
}



