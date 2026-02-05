package com.nashtech.observability_pi_shaped.controller;

import com.nashtech.observability_pi_shaped.dto.CreateOrderRequest;
import com.nashtech.observability_pi_shaped.dto.CreateOrderResponse;
import com.nashtech.observability_pi_shaped.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/createOrder")
    public ResponseEntity<CreateOrderResponse> createOrder(
            @Valid @RequestBody CreateOrderRequest request) {

        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping("/getOrder")
    public ResponseEntity<List<CreateOrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<CreateOrderResponse> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}
