package com.omnis.tradeservice.query.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class OrderEntity implements Persistable<String> {
    @Id
    private String orderId;
    private String assetPair;
    private BigDecimal price;
    private BigDecimal quantity;
    private String side;
    private LocalDateTime createdAt;

    @Transient
    private boolean isNew = false;

    @Override
    @Transient
    public String getId() {
        return orderId;
    }

    @Override
    @Transient
    public boolean isNew() {
        return isNew;
    }
}