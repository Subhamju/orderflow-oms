package com.orderflow.service;

import com.orderflow.domain.Order;
import com.orderflow.dto.OrderRequest;
import com.orderflow.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest request);
    Order getOrderById(Long orderId);
}
