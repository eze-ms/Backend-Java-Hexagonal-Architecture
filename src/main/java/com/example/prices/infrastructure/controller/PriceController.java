package com.example.prices.infrastructure.controller;

import com.example.prices.application.FindApplicablePriceUseCase;
import com.example.prices.infrastructure.dto.PriceResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final FindApplicablePriceUseCase findPriceUseCase;

    public PriceController(FindApplicablePriceUseCase findPriceUseCase) {
        this.findPriceUseCase = findPriceUseCase;
    }

    @Operation(
            summary = "Get applicable price for product and brand at given date",
            description = "Returns the price that applies based on date, productId and brandId, using the highest priority"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Price found"),
            @ApiResponse(responseCode = "404", description = "No applicable price found"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters")
    })

    @GetMapping
    public ResponseEntity<PriceResponseDTO> getApplicablePrice(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam Long productId,
            @RequestParam Long brandId
    ) {
        return findPriceUseCase
                .execute(brandId, productId, date)
                .map(PriceResponseDTO::from)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
