package com.example.charity.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Product {
    UUID id;
    String name;
    BigDecimal price;
    int quantity;
    String image;
    boolean isEdible;
}
