package com.omnis.tradeservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.axonframework.common.jdbc.ConnectionProvider;
import org.axonframework.common.jdbc.DataSourceConnectionProvider;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventhandling.tokenstore.jdbc.JdbcTokenStore;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class AxonConfig {

    @Bean
    @Primary
    public Serializer axonSerializer(ObjectMapper objectMapper) {
        return JacksonSerializer.builder()
                .objectMapper(objectMapper)
                .defaultTyping()
                .build();
    }

    @Bean
    @Primary
    public DataSource dataSource(DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    public TokenStore tokenStore(DataSource dataSource, Serializer serializer) {
        ConnectionProvider connectionProvider = new DataSourceConnectionProvider(dataSource);
        return JdbcTokenStore.builder()
                .connectionProvider(connectionProvider)
                .serializer(serializer)
                .build();
    }

}
