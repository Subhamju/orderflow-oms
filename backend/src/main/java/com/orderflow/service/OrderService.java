package com.orderflow.service;

import com.orderflow.dto.OrderDetailsResponse;
import com.orderflow.dto.OrderRequest;
import com.orderflow.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest request,String idempotencyKey);
    OrderDetailsResponse getOrderById(Long orderId);
}
