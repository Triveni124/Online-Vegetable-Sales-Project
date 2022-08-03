package com.vegetable.controller;

import java.util.List;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.dao.ICartDao;
import com.vegetable.exception.CartItemNotExistException;
import com.vegetable.exception.CartItemsExistException;
import com.vegetable.exception.NoIDFoundException;
import com.vegetable.model.Cart;

@RestController
@CrossOrigin("http://localhost:4200/")
public class ICartController {

	Logger logger=org.slf4j.LoggerFactory.getLogger(ICartController.class);
	@Autowired
	private ICartDao dao;
	
	@PostMapping(path="/addCart")
	public Cart addToCart(@RequestBody Cart cart)throws CartItemsExistException{
		logger.info("cart added");
		return dao.addToCart(cart);
	}
	@DeleteMapping(path="/deleteCart/{id}")
	
	public String removeCart(@PathVariable int id)throws NoIDFoundException{
		logger.info("Cart deleted successfully");
		 dao.removeVegetable(id);
		 return "Vegetable Deleted Successfully";
	}
	@GetMapping(path="/viewAll")
	public List<Cart>viewAllItems(){
		logger.info("View Success");
		return dao.viewAllItems();
	}
	
	@PutMapping(path="/IncreaseVegQuantity/{quantity}/{vegetableId}")
	public Cart IncreaseVegQuantity(@PathVariable int quantity,@PathVariable int vegetableId) {
	logger.info("Quantity increased in cart");
		return dao.increaseVegQuantity(quantity, vegetableId);
		}
	
	
	@PutMapping(path="/DecreaseVegQuantity/{quantity}/{vegetableId}")
	public Cart DecreaseVegQuantity( @PathVariable int quantity,@PathVariable int vegetableId ) {
		logger.info("Quantity decreased in cart");	
		return dao.decreaseVegQuantity(quantity, vegetableId);
				}
	
	@DeleteMapping(path="/removeAllVegetable")
	public String  removeAllVegetable()throws CartItemNotExistException{
	dao.removeAllVegetables();
	return "All vegetables deleted Successfully";
	}
	}
	

