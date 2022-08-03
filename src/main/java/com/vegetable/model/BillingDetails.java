package com.vegetable.model;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="billing_details")
@JsonIgnoreProperties({"hibernateLazyIntializer"})
public class BillingDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int billId;
	@OneToOne
	private Order orderId;
	private String transactionMode;
	private LocalDate transactionDate;
	private String transactionStatus;
	@OneToOne
	//@JoinColumn(name="addressId")
	private Address billingAddress;
	public int getBilliId() {
		return billId;
	}
	public void setBilliId(int billId) {
		this.billId = billId;
	}
	
	
	public Order getOrderId() {
		return orderId;
	}
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
}
