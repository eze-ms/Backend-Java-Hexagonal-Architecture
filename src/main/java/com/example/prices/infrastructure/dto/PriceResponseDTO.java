package com.example.prices.infrastructure.dto;

import com.example.prices.domain.model.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PriceResponseDTO {

    private Long productId;
    private Long brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private String currency;

    public PriceResponseDTO() {
    }

    public PriceResponseDTO(Long productId, Long brandId, Integer priceList,
                            LocalDateTime startDate, LocalDateTime endDate,
                            BigDecimal price, String currency) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currency = currency;
    }

    public static PriceResponseDTO from(Price price) {
        return new PriceResponseDTO(
                price.productId(),
                price.brandId(),
                price.priceList(),
                price.startDate(),
                price.endDate(),
                price.price(),
                price.currency()
        );
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Integer getPriceList() {
        return priceList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
