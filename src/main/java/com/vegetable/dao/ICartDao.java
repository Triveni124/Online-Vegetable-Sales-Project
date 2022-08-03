package com.vegetable.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.exception.CartItemNotExistException;
import com.vegetable.exception.CartItemsExistException;
import com.vegetable.exception.NoIDFoundException;
import com.vegetable.model.Cart;
import com.vegetable.model.VegetablesItems;
import com.vegetable.repository.ICartRepository;
import com.vegetable.repository.IVegetablesItemsRepository;
import com.vegetable.service.ICartService;
@Service
public class ICartDao implements ICartService {

	Logger logger=org.slf4j.LoggerFactory.getLogger(ICartDao.class);
	@Autowired
	private ICartRepository cartrepos;
	
	@Autowired
	private IVegetablesItemsRepository vegrepos;
	@Override
	public Cart addToCart(Cart cart)throws CartItemsExistException {
            //Cart c=veg.getCart();
		if(cartrepos.existsById(cart.getCartId())) {
			logger.error("Cart already exists");
			throw new CartItemsExistException("Items already added");
		}
		else {
			logger.info("cart added successfully");
			 return cartrepos.save(cart);
			 
			
		}
 
		
	
	}

	@Override
	public Cart increaseVegQuantity(int quantity, int vegetableId) {

		VegetablesItems currentQuantity= vegrepos.getVegQuantityById(vegetableId);
		System.out.println(currentQuantity);
		int updateQuantity=currentQuantity.getQuantity()+quantity;
		int k= cartrepos.increaseVegQuantity(updateQuantity, vegetableId);
		if(k>0) {
			System.out.println("Quantity updated");
			return vegrepos.findByVegId(vegetableId);

		}else {
			System.out.println("not updated");
		return null;
		}
			}

	@Override
	public Cart decreaseVegQuantity(int quantity, int vegetableId) {

		VegetablesItems cQuantity= vegrepos.getVegQuantity(vegetableId);
		System.out.println(cQuantity);
		int updateQuantity=cQuantity.getQuantity()-quantity;
		int k= cartrepos.decreseVegQuantity(updateQuantity, vegetableId);
		
		if(k>0) {
			System.out.println("Quantity Updated");
			return vegrepos.findById(vegetableId);
		}
	else {
		System.out.println("Quantity not updated");
		return null;
	}
	
}




	@Override
	public void removeVegetable(int id)throws NoIDFoundException {

		Cart cart=cartrepos.getById(id);
		if(cartrepos.existsById(id)) {
			logger.info("Delete Success");
			cartrepos.delete(cart);
		}
		else {
			logger.error("Id not Exists");
			throw new NoIDFoundException("Cart not found with "+id);
		}
	}

	@Override
	public void removeAllVegetables()throws CartItemNotExistException {
		logger.info("All Items Removed Successfully");		
		cartrepos.removeAllVegetable();
	
	}

	@Override
	public List<Cart> viewAllItems() {
		List<Cart>list=cartrepos.viewAll();
		return list;
		
	}

}
