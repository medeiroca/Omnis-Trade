package com.omnis.tradeservice.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.r2dbc.v1_0.R2dbcTelemetry;
import org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryOptionsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class R2dbcConfig {

    @Bean
    public ConnectionFactoryOptionsBuilderCustomizer tracingCustomizer(OpenTelemetry openTelemetry) {
        return builder -> {
            R2dbcTelemetry telemetry = R2dbcTelemetry.create(openTelemetry);
        };
    }

}
