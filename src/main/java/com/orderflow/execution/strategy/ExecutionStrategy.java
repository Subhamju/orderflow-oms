package com.orderflow.execution.strategy;

import com.orderflow.domain.entity.Order;

public interface ExecutionStrategy {
    void execute(Order order);
}
