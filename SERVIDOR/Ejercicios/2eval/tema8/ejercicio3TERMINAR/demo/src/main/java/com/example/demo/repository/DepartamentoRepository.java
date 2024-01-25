package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento,Long>{
    Departamento findByNombre(String nombre);
    Optional<Departamento> findById(Long id);
}
