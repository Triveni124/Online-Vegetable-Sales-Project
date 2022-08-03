package com.vegetable;



import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.validation.constraints.AssertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.vegetable.dao.ICustomerDao;
import com.vegetable.dao.IFeedbackDao;
import com.vegetable.dao.IVegetablesItemsDao;
import com.vegetable.exception.CustomerAlreadyExistsException;
import com.vegetable.model.Address;
import com.vegetable.model.Cart;
import com.vegetable.model.Customer;
import com.vegetable.model.FeedBack;
import com.vegetable.model.User;
import com.vegetable.model.VegetablesItems;
import com.vegetable.repository.ICustomerRepository;
import com.vegetable.repository.IVegetablesItemsRepository;
import com.vegetable.repository.IfeedbackRepository;
import com.vegetable.service.IVegetableMgmtService;

@SpringBootTest
class OnlineVegetableSalesApplicationTests {

	@Autowired
	ICustomerRepository custrepos;
	
	@Autowired
	ICustomerDao dao;
	/*@Test
	public void testSave() {
		Customer c=new Customer();
		c.setCustomerId(123);	
		c.setName("Rajini");
		c.setMobileNumber("7259723668");
		c.setEmailId("rajini@gmail.com");
		c.setPassword("rajinii123");
		c.setConfirmPassword("rajini123");
		Address add=new Address();
		
		add.setArea("nampalli");
		add.setBuildingName("Deeksha Clasic");
		add.setCity("Mythrivanam");
		add.setPinCode("234568");
		add.setState("Telangana");
		User user=new User();
		
		user.setEmail("abc@gmail.com");
		user.setPassword("abc123");
		user.setRole("Software");
		c.setAddress(add);
		c.setUser(user);
		
		Customer cust=null;
		try {
			cust=dao.addCustomer(c);
			
		}
		
		catch (CustomerAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNull(cust);
	}
	

	*/
	
	
	
	
	
	@Test
	public void testviewCustomerList() {
		List<Customer>list=dao.viewCustomerList("Mythrivanam");
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	public void testviewCustomer() {
		Customer cust=custrepos.findById(7).get();
	}
	
	
	
	
	@Autowired
	private IVegetablesItemsRepository repository;
    @Autowired
    private IVegetablesItemsDao vdao;
    @Test
	 public void testaddVegetable() 
    {
		VegetablesItems veg=new VegetablesItems();
		
        veg.setName("Potato");
        veg.setCategory("brown color");
        veg.setPrice(50.00);
        veg.setQuantity(2);
        
	}
	
	@Autowired
	IfeedbackRepository frepos;
	@Autowired
	IFeedbackDao fdao;
	@Test
	public void testForSave() {
		FeedBack feed=new FeedBack();
		feed.setComments("Nice One");
		feed.setRating(8);
		Customer cu=new Customer();
		cu.setName("Nag");
		cu.setEmailId("nag12@gmail.com");
		cu.setMobileNumber("9865432022");
		cu.setPassword("nag123");
		cu.setConfirmPassword("nag123");

		Address ad=new Address();
		ad.setArea("Gabur");
		ad.setBuildingName("naniApartments");
		ad.setCity("Karnataka");
		ad.setPinCode("569822");
		ad.setState("Banglore");
		cu.setAddress(ad);
		
		User us=new User();
		us.setEmail("banni@gmail.com");
		us.setPassword("banni123");
		us.setRole("Finance Manager");
		cu.setUser(us);
		VegetablesItems veg=new VegetablesItems();
		veg.setCategory("Marrow");
		veg.setName("zucchini");
		veg.setPrice(25);
		veg.setQuantity(2);
		Cart cart=new Cart();
		veg.setCart(cart);
	}
	
	

	@Test
	public void testForViewFeedbackByCustomerId() {
		FeedBack fee=frepos.getById(62);
	}
	@Test
	public void testForViewFeedbackByVegId() {
		FeedBack fee=frepos.getById(141);
	}
}


