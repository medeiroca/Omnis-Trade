package com.omnis.tradeservice.query.projection;

import com.omnis.tradeservice.coreapi.query.FindAllOrdersQuery;
import com.omnis.tradeservice.query.entity.OrderEntity;
import com.omnis.tradeservice.query.repository.TradeRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class OrderQueryHandler {

    private final TradeRepository repository;

    public OrderQueryHandler(TradeRepository repository) {
        this.repository = repository;
    }

    @QueryHandler
    public Flux<OrderEntity> handle(FindAllOrdersQuery query) {
        return repository.findAll();
    }

}
