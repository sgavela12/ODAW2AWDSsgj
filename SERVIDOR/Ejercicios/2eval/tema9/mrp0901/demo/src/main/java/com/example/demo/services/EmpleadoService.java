package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Empleado;
@Service
public interface EmpleadoService {
  Empleado añadir(Empleado empleado);
  List<Empleado> obtenerTodos();
  Empleado obtenerPorId(long id);
  Empleado editar(Empleado empleado);
  void borrar(Long id);

  List<Empleado> obtenerEmpleadosSalarioMayor (double salario);
  List<Empleado> obtenerEmpleadoSalarioMayorMedia();
}
