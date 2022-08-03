package com.vegetable.model;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="customer_info")
@JsonIgnoreProperties({"hibernateLazyIntializer"})
public class Customer {
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int customerId;

	@NotBlank(message="CustomerName Should not blank")
	private String name;
	@NotNull(message="CustomerName should not be null")
	@Pattern(regexp="[789]{1}[0-9]{9}")
	private String mobileNumber;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;

	@Pattern(regexp="[A-Za-z0-9]+[@]{1}[a-zA-z]+[.]{1}[a-z]{3}")
	private String emailId;
	private String password;
	private String confirmPassword;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
