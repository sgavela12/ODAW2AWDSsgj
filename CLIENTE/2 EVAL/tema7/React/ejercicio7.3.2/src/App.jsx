import React, { useState, useEffect } from 'react';
import PilotosForm from './PilotosForm';
import PilotosTabla from './PilotosTabla';

const App = () => {
    const [tabla, setTabla] = useState([]);
    const [paginaActual, setPaginaActual] = useState(1);
    const pilotosPorPagina = 3;

    useEffect(() => {
        cargaXmlFetch();
    }, []);

    const cargaXmlFetch = () => {
        fetch('pilotos.json')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Hubo un problema con la solicitud. Código de estado: ' + response.status);
                }
                return response.json();
            })
            .then(data => {
                mostrarPilotos(data.pilotos);
            })
            .catch(error => {
                console.error('Error en la solicitud:', error);
            });
    };

    const mostrarPilotos = (pilotos) => {
        setTabla(pilotos);
    };

    const actualizarTabla = (pilotos) => {
        setTabla(pilotos);
    };

    return (
        <div>
            <PilotosForm pilotos={tabla} actualizarTabla={actualizarTabla} />
            <PilotosTabla pilotos={tabla} />
        </div>
    );
};

export default App;
