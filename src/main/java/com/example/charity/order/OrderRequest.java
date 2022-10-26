package com.example.charity.order;

import com.example.charity.product.ProductsStock;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class OrderRequest {

    UUID userId;
    BigDecimal totalSum;
    List<ProductsStock> soldProducts;

}

