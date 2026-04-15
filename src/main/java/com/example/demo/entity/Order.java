package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")   // ✅ avoid reserved keyword
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    // 🔹 ONE-TO-MANY
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderLine> orderLines = new ArrayList<>();

    // 🔹 MANY-TO-MANY
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "order_products",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    
    public void addOrderLine(OrderLine line) {
        orderLines.add(line);
        line.setOrder(this);
    }

  
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public List<OrderLine> getOrderLines() { return orderLines; }

    public void setOrderLines(List<OrderLine> orderLines) { this.orderLines = orderLines; }

    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> products) { this.products = products; }
}