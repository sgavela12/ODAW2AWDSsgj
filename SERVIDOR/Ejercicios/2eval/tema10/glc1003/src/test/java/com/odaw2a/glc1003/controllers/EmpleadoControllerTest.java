package com.odaw2a.glc1003.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.odaw2a.glc1003.domain.Empleado;
import com.odaw2a.glc1003.domain.Genero;
import com.odaw2a.glc1003.services.EmpleadoService;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class EmpleadoControllerTest {
    @InjectMocks
    EmpleadoController empleadoController;

    @MockBean
    EmpleadoService empleadoService;

    @Autowired
    MockMvc mockMvc;

    List<Empleado> empleados = new ArrayList<>();

    @BeforeAll
    void initTest() {
        empleados.add(new Empleado(1L, "pepe", "pepe@gmail.com", 800d, true, Genero.Masculino));
        empleados.add(new Empleado(2L, "ana", "ana@gmail.com", 900d, true, Genero.Femenino));
        empleados.add(new Empleado(3L, "luis", "luis@gmail.com", 2000d, true, Genero.Femenino));
    }

    @Test
    public void getAllEmpleadoTest() throws Exception {
        when(empleadoService.obtenerTodos()).thenReturn(empleados);
        mockMvc.perform(get("/empleado")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].nombre", is("luis")))
                .andExpect(jsonPath("$[0].email", is("pepe@gmail.com")))
                .andExpect(jsonPath("$[1].salario", is(900d)));
    }

}
