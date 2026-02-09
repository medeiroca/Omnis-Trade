package com.omnis.tradeservice.api.controller;

import com.omnis.tradeservice.api.dto.OrderResponse;
import com.omnis.tradeservice.coreapi.query.FindAllOrdersQuery;
import com.omnis.tradeservice.query.entity.OrderEntity;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderQueryController {

    private final QueryGateway queryGateway;

    public OrderQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public Flux<OrderResponse> findAll() {
        var future = queryGateway.query(
                new FindAllOrdersQuery(),
                ResponseTypes.multipleInstancesOf(OrderEntity.class)
        );
        return Mono.fromFuture(future)
                .flatMapMany(Flux::fromIterable)
                .map(entity -> new OrderResponse(
                        entity.getOrderId(),
                        entity.getAssetPair(),
                        entity.getPrice(),
                        entity.getQuantity(),
                        entity.getSide(),
                        entity.getCreatedAt()
                ));
    }

}
