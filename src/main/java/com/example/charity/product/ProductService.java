package com.example.charity.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {
    @Resource
    ProductRepository productRepository;
    public List<ProductResponse> getProducts() {
        return productRepository.getProducts();
    }
}
