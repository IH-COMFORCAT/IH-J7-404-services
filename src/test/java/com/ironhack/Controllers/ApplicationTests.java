package com.ironhack.Controllers;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.ironhack.Controllers.entity.*;
import com.ironhack.Controllers.repositories.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.web.context.*;

import java.math.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	ProductRepository productRepository;

	private MockMvc mockMvc;
	private final ObjectMapper objectMapper = new ObjectMapper();


	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

	}


	@Test
	void contextLoads() throws Exception {
		Product product = new Product("Producto", new BigDecimal("25.5"), 199l, Category.DIGITAL, Genre.MOBA);

		String body = objectMapper.writeValueAsString(product);

		MvcResult result = mockMvc.perform(post("/products")
				.content(body).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andReturn();

		Assertions.assertTrue(result.getResponse().getContentAsString().contains("Producto"));



	}

}
