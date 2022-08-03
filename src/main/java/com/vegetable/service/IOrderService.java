package com.vegetable.service;

import java.time.LocalDate;
import java.util.List;

import com.vegetable.exception.NoOrderDateFoundException;
import com.vegetable.exception.NoOrderExistException;
import com.vegetable.exception.NoOrderFoundException;
import com.vegetable.exception.OrderFoundException;
import com.vegetable.model.Order;

public interface IOrderService {

	public Order addOrder(Order order)throws OrderFoundException;
	public Order viewOrder(Order order)throws NoOrderFoundException;
	public Order updateOrderDetails(Order order)throws NoOrderFoundException;
	public List<Order>viewAllOrders();
	public List<Order>viewAllOrders(LocalDate date)throws NoOrderDateFoundException;
	public List<Order>viewOrderList();
	public Boolean cancleOrder(int orderId)throws NoOrderExistException;
	public Order getOrderById(int orderId);
}
