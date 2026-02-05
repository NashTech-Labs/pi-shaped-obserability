package com.nashtech.observability_pi_shaped.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateOrderRequest {

    private String itemName;
    private BigDecimal price;
}
