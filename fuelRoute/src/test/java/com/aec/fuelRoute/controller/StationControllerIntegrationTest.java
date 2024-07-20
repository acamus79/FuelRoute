package com.aec.fuelRoute.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class StationControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        // Agregar estaciones
        mockMvc.perform(post("/api/stations").param("name", "A"));
        mockMvc.perform(post("/api/stations").param("name", "B"));
        mockMvc.perform(post("/api/stations").param("name", "C"));

        // Agregar rutas
        mockMvc.perform(post("/api/routes")
                .param("origin", "A")
                .param("destination", "B")
                .param("cost", "10"));
        mockMvc.perform(post("/api/routes")
                .param("origin", "B")
                .param("destination", "C")
                .param("cost", "5"));
        mockMvc.perform(post("/api/routes")
                .param("origin", "A")
                .param("destination", "C")
                .param("cost", "20"));
    }

    @Test
    public void testGetOptimalRoute() throws Exception {
        mockMvc.perform(get("/api/optimal-route")
                        .param("origin", "A")
                        .param("destination", "C"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\"A\", \"B\", \"C\"]"));
    }
}
