package com.ios.productservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ios.productservice.dto.ProductRequest;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Container
	private static MySQLContainer mysqlContainer = new MySQLContainer();

	@DynamicPropertySource
	public static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.datasource.driver-class-name", mysqlContainer::getDriverClassName);
		dynamicPropertyRegistry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", mysqlContainer::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", mysqlContainer::getPassword);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		
		ProductRequest productRequest = getProductRequest();
		
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
		.andExpect(status().isCreated());
	}

	private ProductRequest getProductRequest() {
		
		return ProductRequest.builder()
				.name("iphone 13")
				.description("iphone 13")
				.price(1200)
				.build();
	}

}
