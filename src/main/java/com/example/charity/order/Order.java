package com.example.charity.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Order {
    UUID id;
    UUID userId;
    BigDecimal totalPrice;
}
