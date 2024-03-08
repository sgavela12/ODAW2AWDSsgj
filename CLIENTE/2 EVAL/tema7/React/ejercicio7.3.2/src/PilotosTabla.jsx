// PilotosTabla.js
import React from 'react';

const PilotosTabla = ({ pilotos }) => {
    const iteraPilotos = (pilotos) => {
        return pilotos.map((piloto, index) => (
            <div key={index} className="filaPiloto">
                {piloto.nombre} {piloto.equipo} {piloto.nacionalidad} {piloto.numero}
            </div>
        ));
    };

    return (
        <div>
            {iteraPilotos(pilotos)}
        </div>
    );
};

export default PilotosTabla;
