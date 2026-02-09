package com.omnis.tradeservice.api.controller;

import com.omnis.tradeservice.api.dto.OrderRequest;
import com.omnis.tradeservice.command.CreateOrderCommand;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class TradeOrderController {

    private final CommandGateway commandGateway;

    @PostMapping
    public Mono<ResponseEntity<String>> createOrder(@Valid @RequestBody OrderRequest request) {
        String orderId = UUID.randomUUID().toString();

        CreateOrderCommand command = new CreateOrderCommand(
                orderId,
                request.assetPair(),
                request.price(),
                request.quantity(),
                request.side()
        );

        return Mono.fromFuture(commandGateway.send(command))
                .map(result -> ResponseEntity.accepted().body(orderId))
                .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().body(e.getMessage())));
    }

}
