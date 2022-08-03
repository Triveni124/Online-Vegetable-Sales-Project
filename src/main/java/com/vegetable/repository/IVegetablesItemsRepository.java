package com.vegetable.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vegetable.model.Cart;
import com.vegetable.model.VegetablesItems;
@Repository
public interface IVegetablesItemsRepository extends JpaRepository<VegetablesItems, Integer>{

	@Query(value = "select * from vegetable_info",nativeQuery = true)
	public List<VegetablesItems> viewAllvegetables();
	
	
	//@Query(value = "select * from VegetablesItems  where category=:param1")
	//List<VegetablesItems> viewvegetableList(@Param("param1")String category);
	

	@Query(value="select v from VegetablesItems v where v.name=:x")
	public List<VegetablesItems> viewvegetableByName(@Param("x")String name);


	@Query(value="select v from VegetablesItems v where v.category=:y")
	public List<VegetablesItems> viewvegetableList(@Param("y")String category);
	
	
	
	
	@Query(value="select v from VegetablesItems v where v.vegetableId=?1")
	public VegetablesItems getVegQuantityById(int vegId);

	@Query(value="select cart from Cart cart inner join VegetablesItems veg ON cart.cartId=veg.cart where veg.vegetableId=?1")
	
	public Cart findByVegId(int vegId);
	
	@Query(value="select v from VegetablesItems v where v.vegetableId=?1")
	public VegetablesItems getVegQuantity(int vegId);
	
	@Query(value="select cart from Cart cart inner join VegetablesItems veg ON cart.cartId=veg.cart where veg.vegetableId=?1")
	
	public Cart findById(int vegId);
	
	@Query(value="select * from vegetabls_items where vegetable_id=?1",nativeQuery=true)
    public Optional<VegetablesItems> getVegetableById(int vegetableId);

}
