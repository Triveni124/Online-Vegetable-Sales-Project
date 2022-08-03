package com.vegetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vegetable.dao.IAdminDao;
import com.vegetable.exception.AdminAlreadyExistException;
import com.vegetable.exception.AdminIdNotFoundException;
import com.vegetable.exception.NoAdminFoundException;
import com.vegetable.model.Admin;
@RestController
@CrossOrigin("http://localhost:4200/")
//@RequestMapping("/api")
public class IAdminController {

	@Autowired
	private IAdminDao dao;
	//Add admin 
	@PostMapping(path="/addAdmin")
	public Admin addAdmin(@RequestBody Admin admin)throws AdminAlreadyExistException{
		return dao.addAdmin(admin);
	}
	//Updte Admin based on id
	@PutMapping(path="/updateAdmin/{adminId}")
	public Admin update(@RequestBody Admin admin, @PathVariable int adminId)throws NoAdminFoundException{
		return dao.updateAdmin(admin);
	}
	@GetMapping(path="/fetch/admin/{adminId}")
	public Admin getAdminById(@PathVariable int adminId) {
		return dao.getAdminById(adminId);
		
	}
	//remove admin
	@DeleteMapping(path="/removeAdmin/{adminId}")
	public void remove(@PathVariable int adminId)throws NoAdminFoundException{
		dao.removeAdmin(adminId);
	}
	//view admin based on id
	@GetMapping(path="/viewAdmin/{id}")
	public Admin view(@PathVariable int id)throws AdminIdNotFoundException, NoAdminFoundException{
		Admin a=dao.findbyId(id);
		
		return dao.viewAdmin(a);
	}
	@GetMapping(path="/viewAdmin")
	public List<Admin>viewAllAdmins(){
		return dao.viewAllAdmins();
		
	}
	
}
