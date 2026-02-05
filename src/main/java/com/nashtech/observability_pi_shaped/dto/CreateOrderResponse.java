package com.nashtech.observability_pi_shaped.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({ "id", "itemName", "price", "status", "createdAt" })
public class CreateOrderResponse {

    private Long id;
    private String itemName;
    private BigDecimal price;
    private String status;
    private LocalDateTime createdAt;
}
