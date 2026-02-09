package com.omnis.tradeservice.query.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String orderId;
    private String assetPair;
    private BigDecimal price;
    private BigDecimal quantity;
    private String side;
    private LocalDateTime createdAt;
}
