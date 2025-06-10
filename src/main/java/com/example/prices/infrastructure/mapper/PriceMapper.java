package com.example.prices.infrastructure.mapper;

import com.example.prices.domain.model.Price;
import com.example.prices.infrastructure.entity.PriceEntity;

public class PriceMapper {

    public static Price toDomain(PriceEntity entity) {
        return new Price(
                entity.getBrandId(),
                entity.getProductId(),
                entity.getPriceList(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrency(),
                entity.getStartDate(),
                entity.getEndDate()
        );
    }

    public static PriceEntity toEntity(Price domain) {
        return PriceEntity.builder()
                .brandId(domain.brandId())
                .productId(domain.productId())
                .priceList(domain.priceList())
                .priority(domain.priority())
                .price(domain.price())
                .currency(domain.currency())
                .startDate(domain.startDate())
                .endDate(domain.endDate())
                .build();
    }
}
