package com.example.prices.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test 1: 14-06-2020 10:00 — should return priceList 1 and price 35.50")
    void shouldReturnCorrectPriceAt10amOnJune14() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("date", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.price", is(35.50)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    @Test
    @DisplayName("Test 2: 14-06-2020 16:00 — should return priceList 2 and price 25.45")
    void shouldReturnCorrectPriceAt4pmOnJune14() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("date", "2020-06-14T16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", is(2)))
                .andExpect(jsonPath("$.price", is(25.45)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    @Test
    @DisplayName("Test 3: 14-06-2020 21:00 — should return priceList 1 and price 35.50")
    void shouldReturnCorrectPriceAt9pmOnJune14() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("date", "2020-06-14T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.price", is(35.50)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    @Test
    @DisplayName("Test 4: 15-06-2020 10:00 — should return priceList 3 and price 30.50")
    void shouldReturnCorrectPriceAt10amOnJune15() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("date", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", is(3)))
                .andExpect(jsonPath("$.price", is(30.50)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }

    @Test
    @DisplayName("Test 5: 16-06-2020 21:00 — should return priceList 4 and price 38.95")
    void shouldReturnCorrectPriceAt9pmOnJune16() throws Exception {
        mockMvc.perform(get("/prices")
                        .param("date", "2020-06-16T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.priceList", is(4)))
                .andExpect(jsonPath("$.price", is(38.95)))
                .andExpect(jsonPath("$.currency", is("EUR")));
    }


}
