package com.example.GJS1006.services;

import java.util.List;

import com.example.GJS1006.domain.Empleado;

public interface EmpleadoService {
    Empleado añadir(Empleado empleado);

    List<Empleado> obtenerTodos();

    Empleado obtenerPorId(long id);

    Empleado editar(Empleado empleado);

    void borrar(Long id);

    List<Empleado> obtenerEmpleadosSalarioMayor (double salario);

    List<Empleado> obtenerEmpleadoSalarioMayorMedia();
}
