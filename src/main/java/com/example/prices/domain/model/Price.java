package com.example.prices.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Price {

    private final Long brandId;
    private final Long productId;
    private final Integer priceList;
    private final Integer priority;
    private final BigDecimal price;
    private final String currency;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public Price(Long brandId, Long productId, Integer priceList, Integer priority,
                 BigDecimal price, String currency, LocalDateTime startDate, LocalDateTime endDate) {
        this.brandId = brandId;
        this.productId = productId;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public Integer getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
