package com.omnis.tradeservice.api.dto;

import com.omnis.tradeservice.domain.OrderSide;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderRequest(
        @NotBlank String assetPair,
        @Positive BigDecimal price,
        @Positive BigDecimal quantity,
        @NotNull OrderSide side
) { }
