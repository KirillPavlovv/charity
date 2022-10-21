package com.example.charity.product;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

public class ProductController {

    @Resource
    ProductService productService;

    @GetMapping("products")
    @Operation(summary = "Get all available products for sale")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

}
