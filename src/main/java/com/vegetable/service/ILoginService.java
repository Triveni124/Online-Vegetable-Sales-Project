package com.vegetable.service;

import com.vegetable.exception.ResourceDBException;
import com.vegetable.model.User;

public interface ILoginService {

	//public User validateLogin(User user) throws ResourceDBException;

	public User logout(User user);
	
	public User getLogin(String email,String password);
}
