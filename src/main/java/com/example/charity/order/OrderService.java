package com.example.charity.order;

import com.example.charity.product.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class OrderService {

    @Resource
    ProductService productService;
    @Resource
    OrderRepository orderRepository;

    public void createOrder(OrderRequest orderRequest) {
        productService.changeStock(orderRequest.getSoldProducts());
        Order order = new Order();
        order.setId(UUID.randomUUID());
        order.setTotalPrice(orderRequest.getTotalSum());
        order.setUserId(orderRequest.getUserId());
        orderRepository.save(order);
    }
}
