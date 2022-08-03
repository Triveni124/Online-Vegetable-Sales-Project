package com.vegetable.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.dao.IBillingDetailsDao;
import com.vegetable.exception.BillAlreadyAdded;
import com.vegetable.exception.NoBillFoundException;
import com.vegetable.exception.NoBillIdFoundException;
import com.vegetable.model.BillingDetails;

@RestController
@CrossOrigin("http://localhost:4200/")
public class IBillinDetailsController {

	Logger logger=org.slf4j.LoggerFactory.getLogger(IBillinDetailsController.class);
	@Autowired
	IBillingDetailsDao dao;
	
	@PostMapping(path="/addBill")
	public BillingDetails addBill(@RequestBody BillingDetails bill)throws BillAlreadyAdded{
		logger.info("Bill Added");
		return dao.addBill(bill);
	}
	
	@PutMapping(path="/updateBill")
	public BillingDetails update(@RequestBody BillingDetails bill)throws NoBillFoundException{
	logger.info("Bill Update Status is Success");
		return dao.updateBill(bill);
	}
	
	@GetMapping(path="/viewById/{id}")
	public BillingDetails viewBill(@PathVariable int id)throws NoBillIdFoundException{
		return dao.viewBill(id);
	}
	
	@GetMapping(path="getBillingDetails/{billId}")
	public BillingDetails getBillingDetailsById(@PathVariable int billId) {
		return dao.getBillingDetailsById(billId);
	}
}
