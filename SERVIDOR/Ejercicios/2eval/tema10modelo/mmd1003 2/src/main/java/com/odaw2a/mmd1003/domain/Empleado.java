package com.odaw2a.mmd1003.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
public class Empleado {
    @Id
    @GeneratedValue
    private Long id;
    
    @NotEmpty
    @Size(min=3)
    private String nombre;
    
    @Email
    private String email;

    private Double salario;

    private Boolean enActivo;

    private Genero genero;
}
