package com.vegetable.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="adress_info")
@JsonIgnoreProperties({"hibernateLazyIntializer"})
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	
	private String buildingName;
	@NotBlank(message="Area  should not blank")
	private String area;
	@NotNull(message="Area should not be null")
	private String city;
	@NotBlank(message="State should not be blank")
	private String state;
	@NotNull(message="State Should not be null")
	@Pattern(regexp="[0-9]{6}")
	private String pinCode;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
}
