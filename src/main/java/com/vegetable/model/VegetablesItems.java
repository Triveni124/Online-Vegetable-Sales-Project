package com.vegetable.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vegetabls_items")
@JsonIgnoreProperties({"hibernateLazyIntializer"})
public class VegetablesItems {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int vegetableId;
@NotBlank(message="VegetableName should not be blank")
private String name;
@NotNull(message="VegetableName Should not be null")
private String category;
private double price;
private int quantity;
@JsonBackReference
@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="veg_cartId")
private Cart cart;

public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}
public int getVegetableId() {
	return vegetableId;
}
public void setVegetableId(int vegetableId) {
	this.vegetableId = vegetableId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}


}
