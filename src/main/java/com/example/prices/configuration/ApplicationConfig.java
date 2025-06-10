package com.example.prices.configuration;

import com.example.prices.application.FindApplicablePriceUseCase;
import com.example.prices.domain.port.PriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public FindApplicablePriceUseCase findApplicablePriceUseCase(PriceRepository priceRepository) {
        return new FindApplicablePriceUseCase(priceRepository);
    }
}
