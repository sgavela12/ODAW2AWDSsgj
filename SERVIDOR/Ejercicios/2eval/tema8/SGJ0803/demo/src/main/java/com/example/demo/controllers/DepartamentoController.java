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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Departamento;
import com.example.demo.services.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

   @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        List<Departamento> listaDepartamento = departamentoService.obtenerTodos();
        if (listaDepartamento.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(listaDepartamento);
    }

    @PostMapping("/new")
    public ResponseEntity<?> newElement(@RequestBody Departamento departamentoForm) {
        Departamento departamentoSaved = departamentoService.nuevoDepartamento(departamentoForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoSaved);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteElement(@PathVariable Long id) {
        Departamento departamento = departamentoService.obtenerDepartamentoPorId(id);
        if (departamento == null)
            return ResponseEntity.notFound().build();
        departamentoService.borrar(departamento.getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editElement(@RequestBody Departamento departamentoForm, @PathVariable Long id) {
        Departamento departamento = departamentoService.obtenerDepartamentoPorId(id);
        if (departamento == null)
            return ResponseEntity.notFound().build();
        else {
            departamento.setId(id);
            departamentoService.editarDepartamento(departamentoForm);
            return ResponseEntity.ok().build();
        }
    }
}
