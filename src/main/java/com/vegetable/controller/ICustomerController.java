package com.vegetable.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vegetable.dao.ICustomerDao;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.NoSuchCustomerException;
import com.vegetable.model.Customer;
@CrossOrigin("http://localhost:4200/")
@RestController
//@RequestMapping("/api")

public class ICustomerController {

	Logger logger = org.slf4j.LoggerFactory.getLogger(ICustomerController.class);
	@Autowired
	ICustomerDao dao;
	
	@PostMapping(path="/addCustomer")
	public Customer addCustomer(@Valid @RequestBody Customer customer)throws CustomerAlreadyExistsException{
		
		Customer cust=dao.addCustomer(customer);
		if(cust!=null) {
			logger.info("customer Object created");
		}
		else {
			logger.error("Customer Object Not created");
		}
		return cust;
		
	}
	
	@PutMapping(path = "/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) throws NoSuchCustomerException {
		logger.info("updated successfully!"); // gives logger information
		return dao.updateCustomer(customer);
	}
	@DeleteMapping(path="/removeCustomer/{customerId}")
	public void remove(@PathVariable int customerId)throws NoSuchCustomerException{
		 dao.removeCustome(customerId);
		 logger.info("Customer Deleted Successfully");
	}
	@GetMapping(path = "/viewCustomer/{id1}")
	public Customer view(@PathVariable int id1) throws NoSuchCustomerException 
	{
		Customer c1 = dao.findbyid(id1);
		return dao.viewCustomer(c1);
	}
	@GetMapping(path="getCustomer/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		return dao.getCustomerById(customerId);
	}
	
	@GetMapping(path="/viewCustomerList/{city}")
	public List<Customer>viewCustomer(@PathVariable String city){
		return dao.viewCustomerList(city);
	}
	@GetMapping(path="/viewAllCustomers")
	public List<Customer>getAllCustomer(){
		return dao.getAllCustomer();
	}

}
