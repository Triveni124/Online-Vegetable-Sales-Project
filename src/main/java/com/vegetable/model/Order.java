package com.vegetable.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="order_details")
@JsonIgnoreProperties({"hibernateLazyIntializer"})
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	@OneToOne
	private Customer customerId;
	@OneToMany
	private List<VegetablesItems>vegetables;
	private double totalAmount;
	//@NotBlank(message="Date mandatory")
	private LocalDate orderDate;
	//@NotNull(message="Date should not be null")
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	private String status;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
