package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Empleado;
import com.example.demo.domain.EmpleadoDTO;
@Service
public interface EmpleadoService {
  Empleado añadir(Empleado empleado);
  List<Empleado> obtenerTodos();
  Empleado obtenerPorId(long id);
  Empleado editar(Empleado empleado);
  void borrar(Long id);
  List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados);

}
