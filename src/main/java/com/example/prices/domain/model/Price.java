package com.example.prices.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(
        Long brandId,
        Long productId,
        Integer priceList,
        Integer priority,
        BigDecimal price,
        String currency,
        LocalDateTime startDate,
        LocalDateTime endDate
) {}
