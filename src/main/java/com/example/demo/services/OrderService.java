package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderLine;
import com.example.demo.entity.Product;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    
    public Order createOrder() {

        Order order = new Order();
        order.setCustomerName("John");

        
        OrderLine line1 = new OrderLine();
        line1.setProduct("Laptop");
        line1.setQuantity(1);

        OrderLine line2 = new OrderLine();
        line2.setProduct("Mouse");
        line2.setQuantity(2);

        order.addOrderLine(line1);
        order.addOrderLine(line2);

        
        Product p1 = new Product();
        p1.setName("Laptop");

        Product p2 = new Product();
        p2.setName("Mouse");

        order.getProducts().add(p1);
        order.getProducts().add(p2);

        return repo.save(order);
    }

    
    public Iterable<Order> getAllOrders() {
        return repo.findAll();
    }
}