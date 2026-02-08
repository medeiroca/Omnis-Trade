package com.omnis.tradeservice.command;

import com.omnis.tradeservice.domain.OrderSide;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

public record CreateOrderCommand(
        @TargetAggregateIdentifier
        String orderId,
        String assetPair,     // ex: "BTC/USDT"
        BigDecimal price,
        BigDecimal quantity,
        OrderSide side        // BUY ou SELL
) {}
