package com.example.activate.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @NotNull
    private String nombre;

    @NotNull
    private String apellidos;

    @Email
    @NotNull
    private String email;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate fechaNacimiento;

    @NotNull
    private String contraseña;

   

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", fechaNacimiento="
                + fechaNacimiento + ", contraseña=" + contraseña + "]";
    }

}
