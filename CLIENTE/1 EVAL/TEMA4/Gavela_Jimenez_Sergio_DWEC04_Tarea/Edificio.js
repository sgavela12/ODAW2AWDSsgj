import { Planta } from "./Planta.js";

export class Edificio {
  constructor(calle, numero, codigoPostal) {
    this.calle = calle;
    this.numero = numero;
    this.codigoPostal = codigoPostal;
    this.plantas = [];
    document.body.appendChild(this.muestraDatosCreacion());
  }

  muestraDatosCreacion() {
    let mensajeHtml = document.createElement("p");
    mensajeHtml.innerHTML = `Construido nuevo edificio en calle: ${this.calle}, nº: ${this.numero}, CP: ${this.codigoPostal}`;
    return mensajeHtml;
  }

  agregarPlantasYPuertas(plantas, puertas, letra) {
    for (let i = 0; i < plantas; i++) {
      this.plantas.push(new Planta(i, puertas));
    }
    let mensajeHtml = document.createElement("p");
    mensajeHtml.innerHTML = `Agregamos  ${plantas} y  ${puertas} puertas al piso ${letra}`;
    document.body.appendChild(mensajeHtml);
  }

  obtenerPuerta(piso, puerta) {
    let plantaCorrecta;
    let puertaCorrecta;
    for (let i = 0; i < this.plantas.length; i++) {
      if (this.plantas[i].getPiso() == piso) {
        plantaCorrecta = this.plantas[i];
      }
    }
    for (let i = 0; i < plantaCorrecta.getPuertas().length; i++) {
      if (plantaCorrecta.getPuertas()[i].getNumero() == puerta - 1) {
        puertaCorrecta = plantaCorrecta.getPuertas()[i];
      }
    }
    return puertaCorrecta;
  }

  modificarNumero(numero) {
    this.numero = numero;
  }

  modificarCalle(calle) {
    this.calle = calle;
  }

  modificarCodigoPostal(codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  imprimeCalle(letra) {
    let mensajeHtml = document.createElement("p");
    mensajeHtml.innerHTML = `La calle del edificio ${letra} es: ${this.calle}`;
    document.body.appendChild(mensajeHtml);
  }

  imprimeNumero(letra) {
    let mensajeHtml = document.createElement("p");
    mensajeHtml.innerHTML = `El edificio ${letra} esta situado en la calle ${this.calle} numero ${this.numero}`;
    document.body.appendChild(mensajeHtml);
  }

  imprimeCodigoPostal(letra) {
    let mensajeHtml = document.createElement("p");
    mensajeHtml.innerHTML = `El código postal del edificio ${letra} es: ${this.codigoPostal}`;
    document.body.appendChild(mensajeHtml);
  }

  agregaPropietario(nombre, planta, puerta, letra) {
    let puertaActual = this.obtenerPuerta(planta, puerta);
    puertaActual.agregaPropietario(nombre);

    let mensajeHtml = document.createElement("p");
    mensajeHtml.innerHTML = `${nombre} es ahora propietario de la puerta ${puerta} de la planta ${planta} del edificio ${letra}`;
    document.body.appendChild(mensajeHtml);
  }

  imprimePropietarios() {
    let mensajeHtml = document.createElement("p");
    document.body.appendChild(mensajeHtml);

    for (let i = 0; i < this.plantas.length; i++) {
      const planta = this.plantas[i];

      const puertas = planta.getPuertas();
      for (let x = 0; x < puertas.length; x++) {
        const puerta = puertas[x];
        if (puerta.getPropietario() != null) {
          let mensajeHtml = document.createElement("p");
          mensajeHtml.innerHTML = `Propietario del piso ${puerta.getNumero()+1} de la planta ${puerta.getPlanta()+1}: ${puerta.getPropietario()} `;
          document.body.appendChild(mensajeHtml);
        }
      }
    }
  }
}
