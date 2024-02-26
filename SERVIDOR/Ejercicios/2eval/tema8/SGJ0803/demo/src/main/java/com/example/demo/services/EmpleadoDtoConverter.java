package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Empleado;
import com.example.demo.dto.EmpleadoNuevoDto;

@Component
public class EmpleadoDtoConverter {
@Autowired
DepartamentoService departamentoService;
public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoNuevoDto) {
return new Empleado(null,
empleadoNuevoDto.getNombre(),
empleadoNuevoDto.getEmail(),
empleadoNuevoDto.getSalario(),
empleadoNuevoDto.isEnActivo(),
empleadoNuevoDto.getGenero(),
departamentoService.obtenerDepartamentoPorId(empleadoNuevoDto.getDepartamentoId()));
}
public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoEditDto, Long id) {
Empleado empleado = convertDtoToEmpleado(empleadoEditDto);
empleado.setId(id);
return empleado;
}
}