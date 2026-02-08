package com.omnis.tradeservice.event;

import com.omnis.tradeservice.domain.OrderSide;

import java.math.BigDecimal;

public record OrderCreatedEvent(
        String orderId,
        String assetPair,
        BigDecimal price,
        BigDecimal quantity,
        OrderSide side
) {
}
