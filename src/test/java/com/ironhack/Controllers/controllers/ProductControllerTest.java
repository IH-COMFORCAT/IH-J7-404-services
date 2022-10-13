package com.ironhack.Controllers.controllers;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.ironhack.Controllers.entity.*;
import com.ironhack.Controllers.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import java.math.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;


    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeEach
    public void setUp() {
            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void get_All_OK() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/product")).andExpect(status().isOk()).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Super Smash Bros"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("49.99"));

        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    void post_Product_isCreated() throws Exception {
        Product product = new Product("Zelda: Breath of the Wild", new BigDecimal("59.99"), 400l, Category.DIGITAL, Genre.OPEN_WORLD);
        String body = objectMapper.writeValueAsString(product);
        System.out.println(body);

        MvcResult mvcResult =mockMvc.perform(post("/products").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(productRepository.findByName("Zelda: Breath of the Wild").isPresent());

    }



}
