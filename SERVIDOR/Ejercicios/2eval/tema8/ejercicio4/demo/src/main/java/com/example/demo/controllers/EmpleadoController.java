package com.example.demo.controllers;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.domain.Empleado;
import com.example.demo.exception.EmpleadoNotFoundException;
import com.example.demo.exception.EmptyEmpleadosException;
import com.example.demo.services.EmpleadoService;

import jakarta.validation.Valid;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public List<Empleado> getList() {
        List<Empleado> listaEmpleados;
        try {
            listaEmpleados = empleadoService.obtenerTodos();
        } catch (EmptyEmpleadosException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
        return listaEmpleados;
    }

    @GetMapping("/empleado/{id}")
    public Empleado getOneElement(@PathVariable Long id) {
        try {
            return empleadoService.obtenerPorId(id);
        } catch (EmpleadoNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @PostMapping("/empleado")
    public ResponseEntity<?> newElement(@Valid @RequestBody Empleado nuevoEmpleado) {
        // @Valid si no se cumple la validación devuelve BAD_REQUEST cod 400
        Empleado empleado = empleadoService.añadir(nuevoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado); // cod 201
    }

    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@Valid @RequestBody Empleado editEmpleado,
            @PathVariable Long id) {
        // @Valid si no se cumple la validación devuelve BAD_REQUEST cod 400
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else {
            empleado = empleadoService.editar(editEmpleado);
            return ResponseEntity.ok(empleado); // cod 200
        }
    }

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        Empleado empleado = empleadoService.obtenerPorId(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        empleadoService.borrar(id);
        return ResponseEntity.noContent().build(); // cod 204
    }
}