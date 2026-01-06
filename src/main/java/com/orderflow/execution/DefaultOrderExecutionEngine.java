package com.orderflow.execution;

import com.orderflow.domain.Order;
import com.orderflow.domain.enums.OrderStatus;
import com.orderflow.execution.strategy.ExecutionStrategy;
import com.orderflow.execution.strategy.ExecutionStrategyFactory;
import com.orderflow.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
public class DefaultOrderExecutionEngine implements OrderExecutionEngine{
    private final ExecutorService executorService;
    private final ExecutionStrategyFactory strategyFactory;
    private final OrderRepository orderRepository;

    public DefaultOrderExecutionEngine(ExecutorService executorService, ExecutionStrategyFactory strategyFactory, OrderRepository orderRepository) {
        this.executorService = executorService;
        this.strategyFactory = strategyFactory;
        this.orderRepository = orderRepository;
    }


    @Override
    public void execute(Order order) {
        executorService.submit(()-> {
            order.setOrderStatus(OrderStatus.EXECUTING);
            orderRepository.save(order);

            ExecutionStrategy executionStrategy = strategyFactory.getStrategy(order.getOrderKind());
            executionStrategy.execute(order);

        });

    }
}
