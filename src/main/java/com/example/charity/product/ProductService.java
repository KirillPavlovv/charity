package com.example.charity.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {
    @Resource
    ProductRepository productRepository;
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
