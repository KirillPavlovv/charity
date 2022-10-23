package com.example.charity.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

@Service
public class ProductService {
    @Resource
    ProductRepository productRepository;
    @Resource
    ProductStockRepository productStockRepository;


    public List<ProductResponse> getProducts() {
        return productRepository.getProducts();
    }

    public void changeStock(List<ProductsStock> orderedProducts) {
        HashSet<ProductsStock> hashSet = new HashSet(orderedProducts);
        for (ProductsStock orderedProduct : hashSet) {
            productStockRepository.changeStock(orderedProduct);
        }
    }
}
