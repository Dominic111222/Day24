package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Order;
import com.example.demo.services.OrderService; // ✅ services (your package)

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    
    @PostMapping
    public Order createOrder() {
        return service.createOrder();
    }

    
    @GetMapping
    public Iterable<Order> getAllOrders() {
        return service.getAllOrders();
    }
}