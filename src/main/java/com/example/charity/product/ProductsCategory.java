package com.example.charity.product;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductsCategory {
    UUID id;
    String name;
    BigDecimal price;
    String image;
    boolean isEdible;
}
