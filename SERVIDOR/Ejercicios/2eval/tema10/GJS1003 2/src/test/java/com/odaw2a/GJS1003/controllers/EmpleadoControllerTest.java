package com.odaw2a.GJS1003.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
//get, post, put...
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//jsonPath,
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

import com.odaw2a.GJS1003.domain.Empleado;
import com.odaw2a.GJS1003.domain.Genero;
import com.odaw2a.GJS1003.services.EmpleadoService;

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

    List<Empleado> mockList;

    @BeforeAll
    public void init() {
        mockList = new ArrayList<>();
        mockList.add(new Empleado(1L, "pepe", "pepe@gmail.com", 2999d, true, Genero.Masculino));
        mockList.add(new Empleado(2L, "eva", "eva@gmail.com", 1999d, true, Genero.Femenino));
        mockList.add(new Empleado(3L, "ana", "ana@gmail.com", 3999d, true, Genero.Otro));

    }

    @Test
    public void getListTest() throws Exception {

        when(empleadoService.obtenerTodos()).thenReturn(mockList);
        mockMvc.perform(get("/empleado")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[1].email", is("eva@gmail.com")));

    }

    @Test
    public void getOneElementTest() throws Exception {

        when(empleadoService.obtenerPorId(2)).thenReturn(mockList.get(1));
        mockMvc.perform(get("/empleado/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("eva@gmail.com")));

    }

}
