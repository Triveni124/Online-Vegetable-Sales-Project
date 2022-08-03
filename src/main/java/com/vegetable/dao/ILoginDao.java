package com.vegetable.dao;

import java.util.Optional;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vegetable.exception.ResourceDBException;
import com.vegetable.model.User;
import com.vegetable.repository.ILoginRepository;
import com.vegetable.service.ILoginService;
@Service
public class ILoginDao implements ILoginService {

	@Autowired
	private ILoginRepository repository;
	
	public User loggedIn = null;

    Logger logger=org.slf4j.LoggerFactory.getLogger(ILoginDao.class);
	/*@Override
	public User validateLogin(User user) throws ResourceDBException {
        // extracting username and password from given user object on  Swagger
        String email=user.getEmail();
        String password=user.getPassword();
        // Check if user provided valid email

        if(!email.contains("@")){
            logger.error("Invalid Email");
            throw new ResourceDBException("Invalid Email");
        }
            
            // Check if user provided valid password

            if(password.length() < 6) {
                logger.error("Password is Invalid");
                throw new ResourceDBException("Password should be more than 6 characters");
            }
            
                // extracting existing user from db to compare with given username and password

                User existingUser = repository.findByEmail(email).orNull();

                
                // check if existinguser is not empty
                
                if(existingUser!= null && existingUser.getEmail().equalsIgnoreCase(email) && existingUser.getPassword().equals(password)) {
                    System.out.println(existingUser.getEmail() + " " + existingUser.getPassword());
                    loggedIn = existingUser;
                    return existingUser;
                }  else {
                    // if exisitinguser is empty that means no user user exists with that email
                    throw new ResourceDBException("User not found in database with email " + email);  
                } 
                
            
                    
                    
        }
	*/

	@Override
	public User logout(User user) {
		
		user.setEmail(null);
		user.setPassword(null);
		
		
		return user;
		
		
	}


	@Override
	public User getLogin(String email, String password) {
		
		return repository.getLogin(email, password);
	}

	
}