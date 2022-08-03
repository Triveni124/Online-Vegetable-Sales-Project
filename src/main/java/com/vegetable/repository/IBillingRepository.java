package com.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vegetable.model.BillingDetails;

@Repository
public interface IBillingRepository extends JpaRepository<BillingDetails, Integer>{

	@Query(value="select * from billing_details where bill_id=?1",nativeQuery = true)
	public BillingDetails getBillingDetailsById(int billId);
	
}
