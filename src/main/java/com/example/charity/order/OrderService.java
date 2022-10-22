package com.example.charity.order;

import com.example.charity.product.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    ProductService productService;

    public void createOrder(OrderRequest orderRequest) {
        productService.changeStock(orderRequest.getSoldProducts());
    }
}
