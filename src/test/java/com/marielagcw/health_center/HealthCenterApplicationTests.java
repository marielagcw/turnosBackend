package com.marielagcw.health_center;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@WithMockUser(value = "username")
class HealthCenterApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(0)
    void contextLoads() {
    }

    // POST NEW SPECIALIST
    @Test
    @Order(1)
    public void testPostNewSpecialist() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/specialists/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Nombre1\",\n" +
                                "    \"lastname\": \"Apellido1\",\n" +
                                "    \"specialty\": \"Especialidad1\"\n" +
                                "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content().contentType("text/plain;charset=UTF-8"))
                .andReturn();

        Assertions.assertEquals("text/plain;charset=UTF-8", mvcResult.getResponse().getContentType());
    }

    // GET ALL SPECIALISTS
    @Test
    @Order(2)
    public void testGetAllSpecialists() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/specialists/find"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$[0].lastname")
                        .value("Apellido1"))
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    // GET SPECIALIST BY ID
    @Test
    @Order(3)
    public void testGetSpecialistById() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/specialists/find/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.lastname")
                        .value("Apellido1"))
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    // DELETE SPECIALIST BY ID

    // UPDATE SPECIALIST BY ID


}
