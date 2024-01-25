
let ventana;
let x = 10;
let y = 10;
let moviendose = false;

function crearVentana() {
    if (ventana && !ventana.closed) {
       
        return;
    }

   
    ventana = window.open('', 'MiVentanaEmergente', 'width=500,height=200');
    ventana.moveTo(0, 0); 
    ventana.document.write('<h1>Ventana Emergente</h1>');

   
    moviendose = true;
    moverVentana();
}

function moverVentana() {
    if (moviendose && ventana && !ventana.closed) {
        let currentX = ventana.screenX;
        let currentY = ventana.screenY;
        let maxX = window.screen.width - ventana.outerWidth;
        let maxY = window.screen.height - ventana.outerHeight;

        
        let newX = currentX + x;
        let newY = currentY + y;

        
        if (newX >= maxX || newX <= 0) {
            x = -x;
        }
        if (newY >= maxY || newY <= 0) {
            y = -y;
        }

       
        ventana.moveTo(newX, newY);

        
        setTimeout(moverVentana, 100);
    }
}

function pararVentana() {
    
    moviendose = false;
}

function borrarVentana() {
    
    if (ventana && !ventana.closed) {
        ventana.close();
    }
}