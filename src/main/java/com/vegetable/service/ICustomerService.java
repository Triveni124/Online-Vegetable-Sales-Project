package com.vegetable.service;

import java.util.List;

import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.NoSuchCustomerException;
import com.vegetable.model.Customer;


public interface ICustomerService {

	public Customer addCustomer(Customer customer)throws CustomerAlreadyExistsException; 
	public Customer updateCustomer(Customer customer)throws NoSuchCustomerException;
	public void removeCustome(int customerId)throws NoSuchCustomerException;
	public Customer viewCustomer(Customer customer)throws NoSuchCustomerException;
	public List<Customer>viewCustomerList(String city);
	public Customer getCustomerById(int customerId);
	public List<Customer>getAllCustomer();
	
}
