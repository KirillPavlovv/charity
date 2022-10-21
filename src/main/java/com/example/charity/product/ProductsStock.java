package com.example.charity.product;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductsStock {
    UUID id;
    int quantity;
}
