package com.omnis.tradeservice.query.projection;

import com.omnis.tradeservice.coreapi.event.OrderCreatedEvent;
import com.omnis.tradeservice.query.entity.OrderEntity;
import com.omnis.tradeservice.query.repository.TradeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

@Component
public class TradeEventHandler {
    private final TradeRepository repository;

    public TradeEventHandler(TradeRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public CompletableFuture<OrderEntity> on(OrderCreatedEvent event) {
        OrderEntity entity = new OrderEntity(
                event.orderId(),
                event.assetPair(),
                event.price(),
                event.quantity(),
                event.side().name(),
                LocalDateTime.now(),
                true
        );

        return repository.save(entity).toFuture();
    }
}
