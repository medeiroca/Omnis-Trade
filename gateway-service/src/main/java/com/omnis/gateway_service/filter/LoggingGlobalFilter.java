package com.omnis.gateway_service.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class LoggingGlobalFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(LoggingGlobalFilter.class);
    private static final String START_TIME = "startTime";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String correlationId = UUID.randomUUID().toString();
        exchange.getAttributes().put(START_TIME, System.currentTimeMillis());

        exchange.getResponse().getHeaders().add("X-Omnis-Trace-Id", correlationId);

        logger.info("Incoming request: {} {} | ID: {}",
                exchange.getRequest().getMethod(),
                exchange.getRequest().getURI().getPath(),
                correlationId);
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute(START_TIME);
            if (startTime != null) {
                long duration = System.currentTimeMillis() - startTime;
                logger.info("Outgoing response: {} | Duration: {}ms | ID: {}",
                        exchange.getResponse().getStatusCode(),
                        duration,
                        correlationId);
            }
        }));
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
