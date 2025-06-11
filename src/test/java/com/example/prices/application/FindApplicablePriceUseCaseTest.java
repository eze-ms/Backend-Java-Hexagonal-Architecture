package com.example.prices.application;

import com.example.prices.domain.model.Price;
import com.example.prices.domain.port.PriceRepository;
import com.example.prices.exception.PriceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FindApplicablePriceUseCaseTest {

    private PriceRepository priceRepository;
    private FindApplicablePriceUseCase useCase;

    @BeforeEach
    void setUp() {
        priceRepository = mock(PriceRepository.class);
        useCase = new FindApplicablePriceUseCase(priceRepository);
    }

    @Test
    @DisplayName("Test 1: 14-06-2020 10:00 — should return priceList 1 and price 35.50")
    void testFindPrice_case1() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        List<Price> mockPrices = List.of(
                new Price(1L, 35455L, 1, 0, new BigDecimal("35.50"), "EUR",
                        LocalDateTime.of(2020, 6, 14, 0, 0),
                        LocalDateTime.of(2020, 12, 31, 23, 59))
        );

        when(priceRepository.findByBrandIdAndProductIdAndDate(brandId, productId, date))
                .thenReturn(mockPrices);

        Price result = useCase.execute(brandId, productId, date);

        assertEquals(1, result.priceList());
        assertEquals(new BigDecimal("35.50"), result.price());
    }

    @Test
    @DisplayName("Test 2: 14-06-2020 16:00 — should return priceList 2 and price 25.45 (higher priority)")
    void testFindPrice_case2() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        List<Price> mockPrices = List.of(
                new Price(1L, 35455L, 1, 0, new BigDecimal("35.50"), "EUR",
                        LocalDateTime.of(2020, 6, 14, 0, 0),
                        LocalDateTime.of(2020, 12, 31, 23, 59)),
                new Price(1L, 35455L, 2, 1, new BigDecimal("25.45"), "EUR",
                        LocalDateTime.of(2020, 6, 14, 15, 0),
                        LocalDateTime.of(2020, 6, 14, 18, 30))
        );

        when(priceRepository.findByBrandIdAndProductIdAndDate(brandId, productId, date))
                .thenReturn(mockPrices);

        Price result = useCase.execute(brandId, productId, date);

        assertEquals(2, result.priceList());
        assertEquals(new BigDecimal("25.45"), result.price());
    }

    @Test
    @DisplayName("Should throw PriceNotFoundException when no prices found")
    void testNoPricesFound_throwsException() {
        LocalDateTime date = LocalDateTime.of(2020, 1, 1, 0, 0);
        Long productId = 35455L;
        Long brandId = 1L;

        when(priceRepository.findByBrandIdAndProductIdAndDate(brandId, productId, date))
                .thenReturn(Collections.emptyList());

        assertThrows(PriceNotFoundException.class, () -> useCase.execute(brandId, productId, date));
    }
}
