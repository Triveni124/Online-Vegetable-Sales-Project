package com.vegetable.service;

import java.util.List;

import com.vegetable.exception.CartItemNotExistException;
import com.vegetable.exception.CartItemsExistException;
import com.vegetable.exception.NoIDFoundException;
import com.vegetable.model.Cart;


public interface ICartService {

	public Cart addToCart(Cart cart)throws CartItemsExistException;
	public Cart increaseVegQuantity(int vegetableId,int quantity);
	public Cart decreaseVegQuantity(int vegetableId,int quantity);
	public void removeVegetable(int id)throws NoIDFoundException;
	public void removeAllVegetables() throws CartItemNotExistException;
	public List<Cart>viewAllItems();
}
