package com.vegetable.repository;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.vegetable.model.Order;
@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer>{

	@Query(value="select * from order",nativeQuery=true)
	public List<Order>viewAllOrders();
	//Based on Date
	@Query(value="select * from order_details where order_date=?1",nativeQuery=true)
	List<Order> viewAllOrders(LocalDate date);
	@Query(value="delete from order_details where order_id=?1",nativeQuery = true)
	public Order cancleOrder(int orderId);
	
	@Query(value="select * from order_details where order_id=?1",nativeQuery = true)
	public Optional<Order> getOrderById(int orderId);
}
