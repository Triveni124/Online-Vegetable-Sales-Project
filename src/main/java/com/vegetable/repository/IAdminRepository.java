package com.vegetable.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vegetable.model.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{

	@Transactional
	@Modifying
	@Query(value="update admin_details set contact_number=?1,email_id=?2 where admin_id=?3",nativeQuery = true)
	public int updateAdminById(String contactNumber,String emailId,int adminId);
	
	@Query(value="select * from admin_details",nativeQuery = true)
	public List<Admin>getAllAdmins();
}
