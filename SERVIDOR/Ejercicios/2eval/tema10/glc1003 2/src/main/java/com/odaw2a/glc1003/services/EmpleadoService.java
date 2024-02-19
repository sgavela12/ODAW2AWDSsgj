package com.odaw2a.glc1003.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.odaw2a.glc1003.domain.Empleado;
import com.odaw2a.glc1003.exceptions.NotFoundException;

@Service
public interface EmpleadoService {

    public Empleado añadir(Empleado empleado);

    public List<Empleado> obtenerTodos();

    public Empleado obtenerPorId(long id) throws NotFoundException;

    public Empleado editar(Empleado empleado);

    public void borrar(Long id);

    List<Empleado> obtenerEmpleadosSalarioMayor(Double salario);

    List<Empleado> obtenerEmpleadoSalarioMayorMedia();

}
