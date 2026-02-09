package com.omnis.tradeservice.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponse(String orderId,
                            String assetPair,
                            BigDecimal price,
                            BigDecimal quantity,
                            String side,
                            LocalDateTime createdAt) {
}
