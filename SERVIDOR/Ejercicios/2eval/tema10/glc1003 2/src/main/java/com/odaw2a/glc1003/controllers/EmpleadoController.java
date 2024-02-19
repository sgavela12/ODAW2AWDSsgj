package com.odaw2a.glc1003.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odaw2a.glc1003.domain.Empleado;
import com.odaw2a.glc1003.exceptions.NotFoundException;
import com.odaw2a.glc1003.services.EmpleadoService;

import jakarta.validation.Valid;

@RequestMapping("/empleado")
@RestController
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("")
    public ResponseEntity<?> getEmpleadoList() {
        List<Empleado> listaEmpleados = empleadoService.obtenerTodos();
        if (listaEmpleados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listaEmpleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByEmpleadoId(@PathVariable Long id) {
        Empleado empleado;
        try {
            empleado = empleadoService.obtenerPorId(id);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("")
    public ResponseEntity<?> newEmpleado(@Valid @RequestBody Empleado empleadoForm) {
        Empleado empleado = empleadoService.añadir(empleadoForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editEmpleado(@Valid @RequestBody Empleado empleadoForm,
            @PathVariable Long id) {
        Empleado empleado;
        try {
            empleado = empleadoService.obtenerPorId(id);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        empleado = empleadoService.editar(empleadoForm);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmpleado(@PathVariable Long id) {
        try {
            empleadoService.obtenerPorId(id);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        empleadoService.borrar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listado1/{salario}")
    public ResponseEntity<?> showListado1(@PathVariable Double salario) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadosSalarioMayor(salario);
        if (empleados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/listado2")
    public ResponseEntity<?> showListado2() {
        List<Empleado> empleados = empleadoService.obtenerEmpleadoSalarioMayorMedia();
        if (empleados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleados);
    }

}
