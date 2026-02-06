package com.nashtech.observability_pi_shaped.controller;



import com.nashtech.observability_pi_shaped.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/delay-test")
    public String delayTest() {
        return orderService.processOrder();
    }
}
