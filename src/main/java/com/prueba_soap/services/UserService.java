package com.prueba_soap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.prueba_soap.models.User;
import com.prueba_soap.repositories.UserRepository;
import com.prueba_soap.services.IUserService;

@Service
public class UserService implements IUserService {

	 @Autowired
	 UserRepository userRepository;
	
	
	@Override
	public User getUserById(long userId) {
		User obj = userRepository.findByUserId(userId);
		return obj;
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);

	}
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();		
	}
	

	@Override
	public void deleteUser(long userId) {
		userRepository.deleteById(userId);

	}
	
}