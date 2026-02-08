package com.omnis.gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("status_route", r -> r.path("/status")
                        .filters(f -> f
                                .setStatus(200)
                                .addResponseHeader("X-Omnis-Status", "Operational")
                                .setResponseHeader("Content-Type", "application/json"))
                        .uri("no://op"))
                .build();
    }

}
