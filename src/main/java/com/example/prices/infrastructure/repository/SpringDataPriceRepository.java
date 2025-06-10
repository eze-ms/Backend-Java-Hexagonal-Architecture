package com.example.prices.infrastructure.repository;

import com.example.prices.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SpringDataPriceRepository extends JpaRepository<PriceEntity, Long> {
    List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long brandId,
            Long productId,
            LocalDateTime date1,
            LocalDateTime date2
    );

}

