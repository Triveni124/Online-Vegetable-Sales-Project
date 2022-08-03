package com.vegetable.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="user_details")
@JsonIgnoreProperties({"hibernateLazyIntializer"})
public class User {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

@Column(name = "password", nullable = false)

private String password;

@Column(name = "role", nullable = false)
@NotBlank(message="Role should not be blank")
private String role;
@NotNull(message="Role Should not be null")

@Column(name="email",nullable=false)
@Pattern(regexp="[A-Za-z0-9]+[@]{1}[a-zA-z]+[.]{1}[a-z]{3}")

private String email;


 
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}



}
