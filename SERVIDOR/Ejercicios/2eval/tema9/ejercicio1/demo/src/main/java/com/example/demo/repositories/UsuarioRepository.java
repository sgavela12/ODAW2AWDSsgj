package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    public Usuario findByNombre(String nombre);
}
