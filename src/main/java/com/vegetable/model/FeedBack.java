package com.vegetable.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Feedback_details")
@JsonIgnoreProperties({"hibernateLazyIntializer"})
public class FeedBack {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedbackId;
@OneToOne
//@JoinColumn(name="customerId")
private Customer customerId;
@OneToOne
private VegetablesItems vegetableId;
private int rating;
@NotBlank(message="Comments Should not be blank")
private String comments;
@NotNull(message="Comments should not be null")
public int getFeedbackId() {
	return feedbackId;
}
public void setFeedbackId(int feedbackId) {
	this.feedbackId = feedbackId;
}


public Customer getCustomerId() {
	return customerId;
}
public void setCustomerId(Customer customerId) {
	this.customerId = customerId;
}
public VegetablesItems getVegetableId() {
	return vegetableId;
}
public void setVegetableId(VegetablesItems vegetableId) {
	this.vegetableId = vegetableId;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}


}
