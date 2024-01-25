package com.example.demo.services;

import java.util.List;

import com.example.demo.domain.Departamento;

public interface DepartamentoService {
    Departamento añadir(Departamento departamento);

    List<Departamento> obtenerTodos();

    Departamento obtenerPorId(long id);

    Departamento editar(Departamento departamento);

    void borrar(Departamento departamento);

    Departamento obtenerPorNombre(String nombre);
}
