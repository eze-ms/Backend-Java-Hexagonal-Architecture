package com.example.prices.domain.port;

import com.example.prices.domain.model.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository {
    List<Price> findByBrandIdAndProductIdAndDate(Long brandId, Long productId, LocalDateTime applicationDate);
}

