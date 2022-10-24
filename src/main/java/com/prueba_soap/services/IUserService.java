package com.prueba_soap.services;
import java.util.List;

import com.prueba_soap.models.User;


public interface IUserService {

	void addUser(User user);
	 
	User getUserById(long userId);
	
	List<User> getAllUsers();
	 
    void updateUser(User user);
    
    void deleteUser(long userId);
    
    


}