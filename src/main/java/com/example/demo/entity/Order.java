package com.example.demo.entity;
<<<<<<< HEAD

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
=======
 
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
 
import com.fasterxml.jackson.annotation.JsonManagedReference;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
@Entity
@Table(name="Orders")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private LocalDateTime createdAt;
@Enumerated(EnumType.STRING)
private Status status;
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public enum Status{
	CREATED,
	INTRANSIT,
	COMPLETED
}
public LocalDateTime getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
 
public List<OrderLine> getOrderLines() {
	return orderLines;
}
public void setOrderLines(List<OrderLine> orderLines) {
	this.orderLines = orderLines;
}
@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonManagedReference
private List<OrderLine> orderLines = new ArrayList<>();
public void addOrderLine(OrderLine line) {
	orderLines.add(line);
	line.setOrder(this);
}
>>>>>>> 4f63680189e8e6c9f3056e59d049e167a39a000c
}