package com.api.product.controller;

import com.api.ApiApplication;
import com.api.product.model.Product;
import com.api.product.repository.ProductRepository;
import com.api.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(classes = ApiApplication.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductService service;

    @MockBean
    ProductRepository productRepository;

    Product PRODUCT_1 = new Product("1423", "Java Book", 12.500);
    Product PRODUCT_2 = new Product("44233", "Jfernancordova Book", 1.500);
    Product PRODUCT_3 = new Product("2233", "Spring Boot Book", 9.500);

    private static final String PRODUCT_URL = "/api/v1/products/";

    @Test
    void getAllProducts_success() throws Exception {
        List<Product> products = new ArrayList<>(Arrays.asList(PRODUCT_1, PRODUCT_2, PRODUCT_3));
        Mockito.when(productRepository.findAll()).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders
                        .get(PRODUCT_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].name", is("Spring Boot Book")));
    }

}
