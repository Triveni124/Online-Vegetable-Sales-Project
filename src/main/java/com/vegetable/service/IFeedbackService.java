package com.vegetable.service;

import java.util.List;


import com.vegetable.exception.FeedbackFoundException;
import com.vegetable.exception.NoCustomerIdExistException;
import com.vegetable.exception.NoVegetableIdFound;
import com.vegetable.model.FeedBack;

public interface IFeedbackService {

	public FeedBack addFeedback(FeedBack feed)throws FeedbackFoundException;
	public List<FeedBack>viewAllFeedbacks(int vegetableId)throws NoVegetableIdFound;
	public List<FeedBack>viewFeedback(int customerId)throws NoCustomerIdExistException;
}
