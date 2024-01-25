document.addEventListener('DOMContentLoaded', function () {
    var fileInput = document.getElementById('fileInput');
    var contentFrame = document.getElementById('contentFrame');

    fileInput.addEventListener('change', function () {
        var file = fileInput.files[0];

        if (file) {
            var reader = new FileReader();

            reader.onload = function (e) {
                // Cargar el contenido del archivo en el iframe
                contentFrame.srcdoc = e.target.result;

                // Mostrar todas las funciones de información al cargar la página
                mostrarInformacion();
                mostrarTextoParrafosEnConsola();
                // Agrega aquí más funciones de información si es necesario
            };

            reader.readAsText(file);
        }
    });

    // Función para contar los párrafos de la página
    function contarParrafos() {
        var parrafos = contentFrame.contentDocument.getElementsByTagName('p');
        return parrafos.length;
    }

    // Función para obtener el texto del segundo párrafo
    function obtenerTextoSegundoParrafo() {
        var parrafos = contentFrame.contentDocument.getElementsByTagName('p');
        if (parrafos.length >= 2) {
            return parrafos[1].innerText;
        } else {
            return 'No hay segundo párrafo';
        }
    }

    // Función para contar el número de enlaces de la página
    function contarEnlaces() {
        var enlaces = contentFrame.contentDocument.getElementsByTagName('a');
        return enlaces.length;
    }

    // Función para obtener la dirección del primer enlace
    function obtenerDireccionPrimerEnlace() {
        var enlaces = contentFrame.contentDocument.getElementsByTagName('a');
        if (enlaces.length > 0) {
            return enlaces[0].href;
        } else {
            return 'No hay enlaces en la página';
        }
    }

    // Función para obtener la dirección del penúltimo enlace
    function obtenerDireccionPenultimoEnlace() {
        var enlaces = contentFrame.contentDocument.getElementsByTagName('a');
        if (enlaces.length > 1) {
            return enlaces[enlaces.length - 2].href;
        } else {
            return 'No hay penúltimo enlace en la página';
        }
    }

    // Función para contar el número de enlaces que apuntan a /wiki/Municipio
    function contarEnlacesAMunicipio() {
        var enlaces = contentFrame.contentDocument.querySelectorAll('a[href="/wiki/Municipio"]');
        return enlaces.length;
    }

    // Función para contar el número de enlaces del primer párrafo
    function contarEnlacesPrimerParrafo() {
        var primerParrafo = contentFrame.contentDocument.querySelector('p');
        if (primerParrafo) {
            var enlaces = primerParrafo.getElementsByTagName('a');
            return enlaces.length;
        } else {
            return 'No hay primer párrafo en la página';
        }
    }

    // Mostrar en consola el texto de todos los elementos <p>
    function mostrarTextoParrafosEnConsola() {
        var parrafos = contentFrame.contentDocument.getElementsByTagName('p');
        for (var i = 0; i < parrafos.length; i++) {
            console.log(parrafos[i].innerText);
        }
    }

    // Mostrar la información al final de la página
    function mostrarInformacion() {
        var infoDiv = contentFrame.contentDocument.createElement('div');
        infoDiv.innerHTML = '<h2>Información de la Página</h2>' +
            '<p>Número de párrafos: ' + contarParrafos() + '</p>' +
            '<p>Texto del segundo párrafo: ' + obtenerTextoSegundoParrafo() + '</p>' +
            '<p>Número de enlaces: ' + contarEnlaces() + '</p>' +
            '<p>Dirección del primer enlace: ' + obtenerDireccionPrimerEnlace() + '</p>' +
            '<p>Dirección del penúltimo enlace: ' + obtenerDireccionPenultimoEnlace() + '</p>' +
            '<p>Número de enlaces a /wiki/Municipio: ' + contarEnlacesAMunicipio() + '</p>' +
            '<p>Número de enlaces del primer párrafo: ' + contarEnlacesPrimerParrafo() + '</p>';

        contentFrame.contentDocument.body.appendChild(infoDiv);
    }

    // Llamada a la función para mostrar la información al cargar la página
    mostrarInformacion();

    // Llamada a la función para mostrar en consola el texto de todos los elementos <p>
    mostrarTextoParrafosEnConsola();
});
