package com.nashtech.observability_pi_shaped.service;



import com.nashtech.observability_pi_shaped.config.DelayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final DelayConfig delayConfig;

    public OrderService(DelayConfig delayConfig) {
        this.delayConfig = delayConfig;
    }

    public String processOrder() {
        log.info("Order processing started");

        simulateDelay("processOrder");

        log.info("Order processing completed");
        return "ORDER_PROCESSED";
    }

    private void simulateDelay(String operation) {
        if (!delayConfig.isEnabled()) {
            return;
        }

        try {
            log.info("Simulating {} ms delay for {}", delayConfig.getMillis(), operation);
            Thread.sleep(delayConfig.getMillis());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.warn("Delay interrupted for {}", operation);
        }
    }
}