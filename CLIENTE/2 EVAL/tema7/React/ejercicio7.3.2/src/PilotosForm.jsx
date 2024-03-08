// PilotosForm.js
import React, { useState, useEffect } from 'react';

const PilotosForm = ({ pilotos, actualizarTabla }) => {
    const [filtro, setFiltro] = useState('nombre');
    const [orden, setOrden] = useState('ascendente');
    const [inputNacionalidad, setInputNacionalidad] = useState('');

    const handleFiltroChange = (e) => {
        setFiltro(e.target.value);
        ordenarTablaPorCriterio(e.target.value);
    };

    const handleOrdenChange = (e) => {
        setOrden(e.target.value);
        ordenarTablaPilotos(e.target.value);
    };

    const handleInputNacionalidadChange = (e) => {
        setInputNacionalidad(e.target.value);
        filtrarPorNacionalidad(e.target.value);
    };

    const ordenarTablaPilotos = (order) => {
        let sortedPilotos;
        if (order === "ascendente") {
            sortedPilotos = [...pilotos].sort((a, b) => a.nombre.localeCompare(b.nombre));
        } else if (order === "descendente") {
            sortedPilotos = [...pilotos].sort((a, b) => b.nombre.localeCompare(a.nombre));
        }
        actualizarTabla(sortedPilotos);
    };

    const ordenarTablaPorCriterio = (criterio) => {
        let sortedPilotos;
        if (criterio === "nombre") {
            sortedPilotos = [...pilotos].sort((a, b) => a.nombre.localeCompare(b.nombre));
        } else if (criterio === "equipo") {
            sortedPilotos = [...pilotos].sort((a, b) => a.equipo.localeCompare(b.equipo));
        }
        actualizarTabla(sortedPilotos);
    };

    const filtrarPorNacionalidad = (nacionalidad) => {
        const filteredPilotos = pilotos.filter(piloto => piloto.nacionalidad.toLowerCase() === nacionalidad.toLowerCase());
        actualizarTabla(filteredPilotos);
    };

    return (
        <div>
            <select name="filtro" value={filtro} onChange={handleFiltroChange}>
                <option value="nombre">Nombre</option>
                <option value="equipo">Equipo</option>
            </select>
            <select name="orden" value={orden} onChange={handleOrdenChange}>
                <option value="ascendente">Ascendente</option>
                <option value="descendente">Descendente</option>
            </select>
            <input type="text" value={inputNacionalidad} onChange={handleInputNacionalidadChange} placeholder="Filtrar por Nacionalidad" />
        </div>
    );
};

export default PilotosForm;
