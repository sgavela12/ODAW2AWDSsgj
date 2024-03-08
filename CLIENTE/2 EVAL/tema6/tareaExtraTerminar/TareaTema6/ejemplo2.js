let sino = true;
let colores = new Array('yellow', 'green', 'black', 'red', 'blue', 'white');
let miColor = colores[0];
let numSelecc = 1;
window.onload = comienzo;
function comienzo() {
	let elementoTabla = document.createElement('table');
	elementoTabla.setAttribute('id', 'miTabla');
	elementoTabla.style.align = 'center';
	elementoTabla.style.border = '2';
	elementoTabla.style.borderColor = 'brown';
	elementoTabla.style.borderStyle = 'solid';
	elementoTabla.style.padding = '0px';
	elementoTabla.style.spacing = '0px';
	elementoTabla.style.margin = '0px';
	let crearEvento = function (elemento, evento, mifuncion) {
		function w3c_crearEvento(elemento, evento, mifuncion) {
			elemento.addEventListener(evento, mifuncion, false);
		}
		function ie_crearEvento(elemento, evento, mifuncion) {
			let fx = function () {
				mifuncion.call(elemento);
			};

			elemento.attachEvent('on' + evento, fx);
		}
		if (typeof window.addEventListener !== 'undefined') {
			return w3c_crearEvento;
		} else if (typeof window.attachEvent !== 'undefined') {
			return ie_crearEvento;
		}
	}();
	let quitarEvento = function (elemento, evento, mifuncion) {
		function w3c_quitarEvento(elemento, evento, mifuncion) {
			elemento.removeEventListener(evento, mifuncion);
		}
		function ie_quitarEvento(elemento, evento, mifuncion) {
			let fu = function () {
				mifuncion.call(elemento);
			};
			elemento.detachEvent('on' + evento, fu);
		}
		if (typeof window.removeEventListener !== 'undefined') {
			return w3c_quitarEvento;
		} else if (typeof window.detachEvent !== 'undefined') {
			return ie_quitarEvento;
		}
	}();

	for (i = 1; i <= 30; i++) {

		let elementoTR = document.createElement('tr');
		elementoTR.style.padding = '0px';
		elementoTR.style.spacing = '0px';
		elementoTR.style.margin = '0px';

		for (e = 1; e <= 30; e++) {
			let bx = "box_" + i + "_" + e;
			let elementoTD = document.createElement('td');
			elementoTD.setAttribute('id', bx);
			elementoTD.style.width = '10px';
			elementoTD.style.height = '10px';
			elementoTD.style.border = '1px';
			elementoTD.style.borderColor = 'grey';
			elementoTD.style.borderStyle = 'solid';
			elementoTD.style.padding = '0px';
			elementoTD.style.spacing = '0px';
			elementoTD.style.margin = '0px';

			elementoTR.appendChild(elementoTD);
		}

		elementoTabla.appendChild(elementoTR);
	}
	document.getElementsByTagName('p').item(1).innerHTML = "Haz CLICK en cualquier celda para actilet/desactilet el Pincel";
	let tablero = document.getElementById('zonadibujo');
	tablero.appendChild(elementoTabla);
	crearEvento(tablero, 'mousedown', comenzar);
	let objetoClase = document.getElementById('paleta').getElementsByTagName('tr').item(0);

	for (c = 0; c < 6; c++) {
		numColor = objetoClase.getElementsByTagName('td').item(c);
		numColor.className = "color" + (c + 1);
		crearEvento(numColor, 'mousedown', cambio);
	}

	seleccionado = objetoClase.getElementsByTagName('td').item(0);
	seleccionado.className += " seleccionado";

	function cambio() {

		for (i = 0; i < 6; i++) {

			objetoClase.getElementsByTagName('td').item(i).className = "color" + (i + 1);
		}
		numSel = this.className.substring(5, 6) - 1;
		this.className = this.className + " seleccionado";
		miColor = colores[numSel];
	}
	comenzar();

	function comenzar() {
		if (sino) {
			sino = false;
			document.getElementById('pincel').innerHTML = "PINCEL DESACTIVADO";
			for (i = 1; i <= 30; i++) {
				for (e = 1; e <= 30; e++) {
					let capa = "box_" + i + "_" + e;
					quitarEvento(document.getElementById(capa), 'mouseover', pintar);
				}
			}
		} else {
			sino = true;
			document.getElementById('pincel').innerHTML = "PINCEL ACTIVADO";
			for (i = 1; i <= 30; i++) {
				for (e = 1; e <= 30; e++) {
					let capa = "box_" + i + "_" + e;
					crearEvento(document.getElementById(capa), 'mouseover', pintar);
				}
			}
		}
	}
	function pintar() {
		this.setAttribute('bgcolor', miColor);
	}
}