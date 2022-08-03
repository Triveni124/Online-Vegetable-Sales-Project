package com.vegetable.repository;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vegetable.model.Cart;


@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>{


	@Query(value = "select * from cart_details",nativeQuery = true)
	public List<Cart> viewAll();
	
	@Modifying
	@Transactional
	@Query(value="delete from vegetabls_items",nativeQuery=true )
	public void  removeAllVegetable();
	
	@Transactional
	@Modifying
	@Query(value="update vegetabls_items set quantity=?1 where vegetable_id=?2",nativeQuery=true)
	public int increaseVegQuantity(int quantity,int vegetableId);
	
	@Transactional
	@Modifying
	@Query(value="update vegetabls_items set quantity=?1 where vegetable_id=?2",nativeQuery=true)
	//@Query(value="update vegetabls_items v set quantity= v.quantity-1 where vegetable_id=?1",nativeQuery=true)
	public int decreseVegQuantity(int quantity,int vegetableId);
}