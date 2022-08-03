package com.vegetable.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.dao.IOrderDao;
import com.vegetable.exception.NoOrderDateFoundException;
import com.vegetable.exception.NoOrderExistException;
import com.vegetable.exception.NoOrderFoundException;
import com.vegetable.exception.OrderFoundException;
import com.vegetable.model.Order;

@RestController
@CrossOrigin("http://localhost:4200/")
public class IOrderController {

	Logger logger=org.slf4j.LoggerFactory.getLogger(IOrderController.class);
	@Autowired
	IOrderDao dao;
	
	@PostMapping(path="/addorder")
	public Order addOrder(@RequestBody Order order)throws OrderFoundException{
		logger.info("Order successfully added");
		return dao.addOrder(order);
	}
	
	@GetMapping(path="/vieworder/{id}")
	public Order viewOrder(@PathVariable int id)throws NoOrderFoundException{
		Order order=dao.findbyId(id);
		return dao.viewOrder(order);
	}
	@PutMapping(path="/updateOrder")
	public Order updateOrder(@RequestBody Order order)throws NoOrderFoundException{
		logger.info("Order update success");
		return dao.updateOrderDetails(order);
	}
	@GetMapping(path="/viewAllorders")
	public List<Order>viewAllOrders(){
		logger.info("All orders vied Suucess");
		return dao.viewAllOrders();
	}
	
	@GetMapping(path="/orderList")
	public List<Order>viewOrderList(){
		logger.info("Order Successfully viewd");
		return dao.viewOrderList();
	}
	
	@GetMapping(path="/AllOrders/{date}")
	public List<Order>viewAllOrders(@PathVariable String date) throws NoOrderDateFoundException{
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1=LocalDate.parse(date, dateFormat);
		logger.info("Order Successfully viwed based on date");
		return dao.viewAllOrders(date1);
		
	}
	@GetMapping(path="/getOrderById/{orderId}")
	public  Order getOrderById(@PathVariable int orderId)
	{
		return dao.getOrderById(orderId);
		
	}
	
	@DeleteMapping(path = "/cancelorder/{orderId}")
	public ResponseEntity<String> cancelOrder (@PathVariable int orderId) throws NoOrderExistException
	{
		try {
			dao.cancleOrder(orderId);
		}
		catch(NoOrderExistException ne) {
			throw ne;
		}
		return new ResponseEntity<String>("Order cancelled Successfully!!", HttpStatus.OK);
	}
}
