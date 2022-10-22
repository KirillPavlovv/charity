package com.example.charity.order;

import com.example.charity.product.ProductsStock;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class OrderRequest {

    UUID userId;
    BigDecimal amountToPay;
    List<ProductsStock> soldProducts;

}
