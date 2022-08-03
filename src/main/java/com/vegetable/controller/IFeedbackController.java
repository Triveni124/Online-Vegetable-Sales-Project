package com.vegetable.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.dao.IFeedbackDao;
import com.vegetable.exception.FeedbackFoundException;
import com.vegetable.exception.NoCustomerIdExistException;
import com.vegetable.exception.NoVegetableIdFound;
import com.vegetable.model.FeedBack;

@RestController
@CrossOrigin("http://localhost:4200/")
public class IFeedbackController {

	Logger logger=org.slf4j.LoggerFactory.getLogger(IFeedbackController.class);
	@Autowired
	private IFeedbackDao dao;
	
	@PostMapping(path="/addFeedback")
	public FeedBack addFeedback(@RequestBody FeedBack feed)throws FeedbackFoundException{
		return dao.addFeedback(feed);
	}
	@GetMapping(path="/getFeedbck/{customerId}")
	public List<FeedBack>viewFeedback(@PathVariable int customerId)throws NoCustomerIdExistException{
		logger.info("Feedback fetched Successfully");
		return dao.viewFeedback(customerId);
	}
	@GetMapping(path="/getAllFeedbacks/{vegetableId}")
	public List<FeedBack>ViewAllFeedbacks(@PathVariable int vegetableId)throws NoVegetableIdFound{
		logger.info("Feedback fetched Successfully");
		return dao.viewAllFeedbacks(vegetableId);
	}
}
