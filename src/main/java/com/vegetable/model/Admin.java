package com.vegetable.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="admin_details")
@JsonIgnoreProperties({"hibernateLazyIntializer"})
public class Admin {
	
	@OneToOne(cascade=CascadeType.ALL)
	public User user;
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int adminId;
@NotBlank(message="Admin name sholud not be blank")
private String name;
@NotNull(message="Admin name should not be null")
@Pattern(regexp="(0|91)?[7-9][0-9]{9}")
public String contactNumber;
@Pattern(regexp="[A-Za-z0-9]+[@]{1}[a-zA-z]+[.]{1}[a-z]{3}")
private String emailId;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContactNumber() {
	return contactNumber;
}
public void setContactNumber(String contactNumber) {
	this.contactNumber = contactNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}

}
