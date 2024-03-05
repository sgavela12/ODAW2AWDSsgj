package com.example.GJS0601.Services;

import java.util.List;

import com.example.GJS0601.Domain.Empleado;

public interface EmpleadoService {
    Empleado añadir (Empleado empleado);
    List<Empleado> obtenerTodos ();
    Empleado obtenerPorId (long id);
    Empleado editar (Empleado empleado);
    void borrar (Long id);
}
