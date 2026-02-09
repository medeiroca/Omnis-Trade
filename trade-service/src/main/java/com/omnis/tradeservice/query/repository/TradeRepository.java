package com.omnis.tradeservice.query.repository;

import com.omnis.tradeservice.query.entity.OrderEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends R2dbcRepository<OrderEntity, String> {
}
