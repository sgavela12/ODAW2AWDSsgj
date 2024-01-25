import { Edificio } from "./Edificio.js";

let edificios = []

let edificio = new Edificio("Garcia Prieto",58,15706)
let edificio2 = new Edificio("Camino Caneiro",29,32004)
let edificio3 = new Edificio("San Clemente",29,15705)


edificio.imprimeCodigoPostal("A")
edificio3.imprimeCalle("C")
edificio2.imprimeNumero("B")


edificio.agregarPlantasYPuertas(2,3,"A")

edificio.agregaPropietario("Jose Antonio Lopez",1,1,"A")
edificio.agregaPropietario("Luisa Martinez",1,2,"A")
edificio.agregaPropietario("Marta Castellon",1,3,"A")

edificio.imprimePropietarios()