package com.example.charity.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

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
        for (ProductsStock orderedProduct : orderedProducts) {
            productStockRepository.changeStock(orderedProduct);
        }
//        for (UUID key : orderedProducts.keySet()) {
//            ProductsStock productsStock = new ProductsStock();
//            productsStock.setId(key);
//            productsStock.setQuantity(orderedProducts.get(key));
//            productStockRepository.changeStock(productsStock);
//        }
    }
}
