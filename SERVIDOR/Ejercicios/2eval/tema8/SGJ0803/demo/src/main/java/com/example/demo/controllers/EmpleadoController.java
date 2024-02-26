package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Empleado;
import com.example.demo.dto.EmpleadoDto;
import com.example.demo.dto.EmpleadoNuevoDto;
import com.example.demo.services.DepartamentoService;
import com.example.demo.services.EmpleadoDtoConverter;
import com.example.demo.services.EmpleadoService;

@RestController
public class EmpleadoController {

  @Autowired
  EmpleadoService empleadoService;
  @Autowired
  DepartamentoService departamentoService;

  @Autowired
  public ModelMapper modelMapper;

  @Autowired
  public EmpleadoDtoConverter empleadoDtoConverter;

  @GetMapping("/empleado")
  public ResponseEntity<?> getList() {
    List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
    if (listaEmpleados.isEmpty())
      return ResponseEntity.notFound().build(); // cod 404
    else {
      List<EmpleadoDto> listaEmpleadoDto = new ArrayList<>();
      for (Empleado e : listaEmpleados)
        listaEmpleadoDto.add(modelMapper.map(e, EmpleadoDto.class));
      return ResponseEntity.ok(listaEmpleadoDto); // cod 200
    }
  }

  @PostMapping("/empleado")
  public ResponseEntity<?> newElement(@RequestBody EmpleadoNuevoDto empleadoNuevoDto) {
    Empleado empleado = empleadoDtoConverter.convertDtoToEmpleado(empleadoNuevoDto);
    Empleado empleadoSaved = empleadoService.añadir(empleado);
    return ResponseEntity.status(HttpStatus.CREATED).body(empleadoSaved);
  }

  @PutMapping("/empleado/{id}")
  public ResponseEntity<?> editElement(@RequestBody EmpleadoNuevoDto editEmpleado,
      @PathVariable Long id) {
    Empleado empleado = empleadoService.obtenerPorId(id);
    if (empleado == null)
      return ResponseEntity.notFound().build(); // cod 404
    else {
      empleado = empleadoDtoConverter.convertDtoToEmpleado(editEmpleado, id);
      Empleado empleadoSaved = empleadoService.editar(empleado);
      return ResponseEntity.ok(empleadoSaved); // cod 200
    }
  }
}
