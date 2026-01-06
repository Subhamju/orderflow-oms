package com.orderflow.execution;

import com.orderflow.domain.Order;

public interface OrderExecutionEngine {
    void execute(Order order);
}
