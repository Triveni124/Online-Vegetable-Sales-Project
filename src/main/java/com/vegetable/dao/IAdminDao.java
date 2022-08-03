package com.vegetable.dao;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.exception.AdminAlreadyExistException;
import com.vegetable.exception.AdminIdNotFoundException;
import com.vegetable.exception.NoAdminFoundException;
import com.vegetable.model.Admin;
import com.vegetable.repository.IAdminRepository;
import com.vegetable.service.IAdminService;
@Service
public class IAdminDao implements IAdminService {

	@Autowired
	private IAdminRepository repository;
	Logger logger=org.slf4j.LoggerFactory.getLogger(IAdminDao.class);
	
	@Override
	public Admin addAdmin(Admin admin)throws AdminAlreadyExistException {
		if(repository.existsById(admin.getAdminId())) {
			logger.error("Admmin Already Exist Exception");
			throw new AdminAlreadyExistException("Admin Already Exists");
		}
		else {
			logger.info("Admin added Succesfully");
			return repository.save(admin);
		}
		
	}

	@Override
	public Admin updateAdmin(Admin admin)throws NoAdminFoundException {
		
		/*if(repository.existsById(admin.getAdminId())) {
			logger.info("Admin updated Successfully");
			return repository.save(admin);
		}
		else {
			logger.error("No Admin Exist Exception");
			throw new NoAdminFoundException("Admin Not Exists");
		}*/
		int status=0;
		int adId=admin.getAdminId();
		String contactNumber=admin.getContactNumber();
		String emailId=admin.getEmailId();
		status=repository.updateAdminById(contactNumber, emailId, adId);
		if(status>=1) 
			return admin;
		
		return null;
		
	}

	@Override
	public Admin viewAdmin(Admin admin)throws AdminIdNotFoundException {
		
		if(repository.existsById(admin.getAdminId())) {
			logger.info("Admin view Successfully");
			return repository.getById(admin.getAdminId());
		}
		else {
			logger.error("Admin Id not found exception");
			throw new AdminIdNotFoundException("Admin not exists");
		}
		
	}

	public Admin findbyId(int id)throws NoAdminFoundException {
		
		return repository.findById(id).orElseThrow(()-> new NoAdminFoundException("Admin not exists"));
	}

	@Override
	public Admin getAdminById(int AdminId) {
		
		return repository.findById(AdminId).get();
	}

	@Override
	public void removeAdmin(int adminId) throws NoAdminFoundException {

		Admin admin=repository.getById(adminId);
		if(repository.existsById(adminId))
			repository.delete(admin); 
	}

	@Override
	public List<Admin> viewAllAdmins() {
		return repository.getAllAdmins();
	}

}
