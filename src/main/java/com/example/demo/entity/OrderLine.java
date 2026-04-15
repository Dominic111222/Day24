package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_lines")   // ✅ IMPORTANT FIX
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}