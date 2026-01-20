package com.orderflow.repository;

import com.orderflow.domain.entity.Order;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<Order> findByUserIdAndIdempotencyKey(
        Long userId,
        String idempotencyKey
    );
}
