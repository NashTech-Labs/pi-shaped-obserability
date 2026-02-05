package com.nashtech.observability_pi_shaped.service;

import com.nashtech.observability_pi_shaped.dto.CreateOrderRequest;
import com.nashtech.observability_pi_shaped.dto.CreateOrderResponse;
import com.nashtech.observability_pi_shaped.entity.Order;
import com.nashtech.observability_pi_shaped.entity.OrderStatus;
import com.nashtech.observability_pi_shaped.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        Order order = new Order(
                request.getItemName(),
                request.getPrice(),
                OrderStatus.CREATED
        );
        Order saved = orderRepository.save(order);
        return mapToResponse(saved);
    }

    public List<CreateOrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public CreateOrderResponse getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException("Order not found with id: " + orderId));
        return mapToResponse(order);
    }

    private CreateOrderResponse mapToResponse(Order saved) {
        return new CreateOrderResponse(
                saved.getId(),
                saved.getItemName(),
                saved.getPrice(),
                saved.getStatus().name(),
                saved.getCreatedAt()
        );
    }
}
