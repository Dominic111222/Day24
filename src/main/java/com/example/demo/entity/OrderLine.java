package com.example.demo.entity;
<<<<<<< HEAD

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
=======
 
import com.fasterxml.jackson.annotation.JsonBackReference;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
@Entity
public class OrderLine {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;
private String item;
private double price;
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
 
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
 
@ManyToOne
@JoinColumn(name="order_id")
@JsonBackReference 
private Order order;
>>>>>>> 4f63680189e8e6c9f3056e59d049e167a39a000c
}