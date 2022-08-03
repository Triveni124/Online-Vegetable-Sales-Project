package com.vegetable.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JsonIgnoreProperties({"hibernateLazyIntializer"})
@Entity
@Table(name="cart_details")
public class Cart {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
    @OneToOne
    private Customer customerId;
    @JsonManagedReference
@OneToMany(cascade=CascadeType.ALL,mappedBy="cart",fetch=FetchType.LAZY)
//@JoinColumn(name="vegetableId")
private List<VegetablesItems>vegetables;
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}

public Customer getCustomerId() {
	return customerId;
}
public void setCustomerId(Customer customerId) {
	this.customerId = customerId;
}
public List<VegetablesItems> getVegetables() {
	return vegetables;
}
public void setVegetables(List<VegetablesItems> vegetables) {
	this.vegetables = vegetables;
}

    
}
