package com.example.prices.infrastructure.repository;

import com.example.prices.domain.model.Price;
import com.example.prices.domain.port.PriceRepository;
import com.example.prices.infrastructure.mapper.PriceMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JpaPriceRepository implements PriceRepository {
    private final SpringDataPriceRepository springRepo;
    private final PriceMapper priceMapper;

    public JpaPriceRepository(SpringDataPriceRepository springRepo, PriceMapper priceMapper) {
        this.springRepo = springRepo;
        this.priceMapper = priceMapper;
    }

    @Override
    public List<Price> findByBrandIdAndProductIdAndDate(Long brandId, Long productId, LocalDateTime date) {
        return springRepo.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
                brandId, productId, date, date
        ).stream().map(priceMapper::toDomain).toList();
    }
}


