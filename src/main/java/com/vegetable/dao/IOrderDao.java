package com.vegetable.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.exception.NoOrderDateFoundException;
import com.vegetable.exception.NoOrderExistException;
import com.vegetable.exception.NoOrderFoundException;
import com.vegetable.exception.OrderFoundException;
import com.vegetable.model.Order;
import com.vegetable.repository.IOrderRepository;
import com.vegetable.service.IOrderService;
@Service
public class IOrderDao implements IOrderService{

	@Autowired
	IOrderRepository orderrepos;
	Logger logger=org.slf4j.LoggerFactory.getLogger(IOrderDao.class);
	@Override
	public Order addOrder(Order order)throws OrderFoundException {

		if(orderrepos.existsById(order.getOrderId())) {
			logger.error("Order already placed");
			throw new OrderFoundException("order Found Excpetion");
		}
		else {
			logger.info("Order placed Success");
			return orderrepos.save(order);
		}
	}

	@Override
	public Order viewOrder(Order order)throws NoOrderFoundException {

		if(orderrepos.existsById(order.getOrderId())) {
			logger.info("Order view Success");
			return orderrepos.getById(order.getOrderId());
		}
		else {
			logger.error("No order to view");
			throw new NoOrderFoundException("Order not found exception");
		}
	}

	@Override
	public Order updateOrderDetails(Order order)throws NoOrderFoundException {

		if(orderrepos.existsById(order.getOrderId())) {
			logger.info("Order update Success");
			return orderrepos.save(order);
		}
		else {
			logger.error("No order found to update");
			throw new NoOrderFoundException("No Order found to update");
		}
	}

	@Override
	public List<Order> viewAllOrders() {

		List<Order>list=orderrepos.findAll();
		return list;
	}

	@Override
	public List<Order> viewAllOrders(LocalDate date)throws NoOrderDateFoundException {

		logger.info("order Successfully viwed based on date");
		return orderrepos.viewAllOrders(date);
	}

	@Override
	public List<Order> viewOrderList() {

		List<Order>or=orderrepos.findAll();
		return or;
	}

	@Override
	public Boolean cancleOrder(int orderId)throws NoOrderExistException {
		
		Optional<Order> or=orderrepos.findById(orderId);
		Order order;
          if(or.isEmpty())
			{
        	  throw new  NoOrderExistException("Order not found with"+ " "+orderId);
			}
			else
			{
				order=or.get();
				orderrepos.delete(order);
				
			}
		return true;
		
	}
	public Order findbyId(int id)throws NoOrderFoundException {

		return orderrepos.findById(id).orElseThrow(()-> new NoOrderFoundException("Order not found"));
	}

	@Override
	public Order getOrderById(int orderId) {
		if(orderrepos.existsById(orderId)) {
			Optional<Order> opt= orderrepos.getOrderById(orderId);
			Order o=opt.get();
			return o;
		}
		return null;
	}

}
