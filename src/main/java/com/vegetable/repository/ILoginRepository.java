package com.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.vegetable.model.User;
@Repository
public interface ILoginRepository extends JpaRepository<User, Integer>{

	//Optional<User> findByEmail(String email);

	@Query(value="select u from User u where u.email=?1 and u.password=?2")
	public User getLogin(String email,String password);
	

	

	
}
