package com.example.prices.application;

import com.example.prices.domain.model.Price;
import com.example.prices.domain.port.PriceRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

public class FindApplicablePriceUseCase {

    private final PriceRepository priceRepository;

    public FindApplicablePriceUseCase(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Price execute(Long brandId, Long productId, LocalDateTime applicationDate) {
        return priceRepository
                .findByBrandIdAndProductIdAndDate(brandId, productId, applicationDate)
                .stream()
                .max(Comparator.comparingInt(Price::priority))
                .orElseThrow(() -> new PriceNotFoundException("No se encontró un precio aplicable para los parámetros proporcionados."));
    }
}
