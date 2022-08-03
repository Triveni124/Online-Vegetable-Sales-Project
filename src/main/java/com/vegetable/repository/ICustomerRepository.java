package com.vegetable.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vegetable.model.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	/*@Transactional
	@Modifying
	@Query(value="update Customer cust set cust=?1 where cust.customerId=?2")
	public int updateCustomerById(Customer customer,int customerId);*/
	
	//@Query(value="select c from Customer c where c.name=:param1")
	@Query(value="select c from Customer c inner join Address a on a.addressId=c.address where a.city=:param1")
	public List<Customer>viewCustomerByLocation(@Param("param1")String city);
	
	@Query(value="select * from customer_info",nativeQuery = true)
	public List<Customer>getAllCustomers();
}
