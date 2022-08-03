package com.vegetable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vegetable.model.FeedBack;
@Repository
public interface IfeedbackRepository extends JpaRepository<FeedBack, Integer>{
	
	//Based on VegetableId view feedback
	@Query(value="select * from feedback_details where vegetable_id_vegetable_id=?1",nativeQuery=true)
public List<FeedBack>viewFeedback(int vegetableId);
	
	//Based on customerId view feedback
@Query(value="select * from feedback_details where customer_id_customer_id=?1",nativeQuery=true)	
public List<FeedBack>viewAllFeedback(int customerId);
	
	
}
