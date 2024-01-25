var ventana;



function abrirVentana() {
    
    ventana = window.open('https://www.ejemplo.com', 'MiVentanaEmergente', 'width=500,height=300');
    ventana.moveBy(500,50)
    
    
    setTimeout(function() {
        if (ventana && !ventana.closed) {
            ventana.close();
        }
    }, 3000);
}

function cerrarVentana() {
    
    if (ventana && !ventana.closed) {
        ventana.close();
    }
}