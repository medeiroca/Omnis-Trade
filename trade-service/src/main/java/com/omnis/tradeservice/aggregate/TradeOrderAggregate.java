package com.omnis.tradeservice.aggregate;

import com.omnis.tradeservice.command.CreateOrderCommand;
import com.omnis.tradeservice.event.OrderCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
@NoArgsConstructor
public class TradeOrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private boolean completed;

    @CommandHandler
    public TradeOrderAggregate(CreateOrderCommand command) {
        if (command.price().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        AggregateLifecycle.apply(new OrderCreatedEvent(
                command.orderId(),
                command.assetPair(),
                command.price(),
                command.quantity(),
                command.side()
        ));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.orderId();
        this.completed = false;
    }

}
