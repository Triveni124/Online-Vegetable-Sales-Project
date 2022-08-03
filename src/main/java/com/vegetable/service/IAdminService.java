package com.vegetable.service;

import java.util.List;

import com.vegetable.exception.AdminAlreadyExistException;
import com.vegetable.exception.AdminIdNotFoundException;
import com.vegetable.exception.NoAdminFoundException;
import com.vegetable.model.Admin;

public interface IAdminService {

	public Admin addAdmin(Admin admin)throws AdminAlreadyExistException;
	public Admin updateAdmin(Admin admin)throws NoAdminFoundException;
	public void removeAdmin(int adminId)throws NoAdminFoundException;
	public Admin viewAdmin(Admin admin)throws AdminIdNotFoundException;
	public List<Admin>viewAllAdmins();
	public Admin getAdminById(int AdminId);
}
