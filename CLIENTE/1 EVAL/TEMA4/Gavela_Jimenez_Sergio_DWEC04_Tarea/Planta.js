import { Puerta } from "./Puerta.js";

export class Planta {
  constructor(piso, numPuertas) {
    this.piso = piso;
    this.numPuertas = numPuertas;
    this.puertas = [];
    for (let i = 0; i < this.numPuertas; i++) {
      this.puertas.push(new Puerta(this.piso,i));
    }


  }
  getPiso() {
    return this.piso;
  }

  getPuertas() {
    return this.puertas;
  }

  getNumeroPuertas() {
    return this.numPuertas;
  }
}
