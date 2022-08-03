package com.vegetable.dao;

import java.util.List;



import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.exception.NoSuchCustomerException;
import com.vegetable.model.Customer;
import com.vegetable.repository.ICustomerRepository;
import com.vegetable.service.ICustomerService;


@Service
public class ICustomerDao implements ICustomerService{

	
	@Autowired
	private ICustomerRepository custrepos;
	
	Logger logger=org.slf4j.LoggerFactory.getLogger(ICustomerDao.class);
	@Override
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException 
	{

		if(custrepos.existsById(customer.getCustomerId()))
		{
			logger.error("Customer already exists exception");
			throw new CustomerAlreadyExistsException("Customer already exists");
		}
		else
		{
			logger.info("Customer added successfully");
			return custrepos.save(customer);
		}	}

	@Override
	public Customer updateCustomer(Customer customer)throws NoSuchCustomerException {
		

		if(custrepos.existsById(customer.getCustomerId()))
		{
			logger.info("Customer updated successfully");
			return custrepos.save(customer);
		}
		else
		{
			logger.error("No such Customer exists exception");
			throw new NoSuchCustomerException("Customer does not exist");
		}
	
		
		
	}

	
	@Override
	public Customer viewCustomer(Customer customer)throws NoSuchCustomerException {

		if(custrepos.existsById(customer.getCustomerId()))
		{
			logger.info("Customer view successful");
			return custrepos.getById(customer.getCustomerId());
		}
		else
		{
			logger.error("No such Customer exists exception");
			throw new NoSuchCustomerException("Customer does not exist");
		}	}

	@Override
	public List<Customer> viewCustomerList(String city) {

		return custrepos.viewCustomerByLocation(city);
	}

	public Customer findbyid(int id)throws NoSuchCustomerException{
		return custrepos.findById(id).orElseThrow(()-> new NoSuchCustomerException("customer does not exist"));
	}

	@Override
	public Customer getCustomerById(int customerId) {
		if(custrepos.existsById(customerId)) {
			java.util.Optional<Customer> opt= custrepos.findById(customerId);
			Customer cust=opt.get();
			return cust;
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return custrepos.getAllCustomers();
		
		
	}

	@Override
	public void removeCustome(int customerId) throws NoSuchCustomerException {
		Customer customer=custrepos.getById(customerId);
		if(custrepos.existsById(customerId)) {
			custrepos.delete(customer);
			logger.info("Customer Deleted");
		}
		
	}

}
