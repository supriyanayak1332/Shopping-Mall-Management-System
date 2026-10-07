package com.example.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.entity.User;
import com.example.shoppingmall.repository.Userrepository;

@Service
 //--it contains the business logic
public class Userservice {

	@Autowired
	//its connects with the user repository
	private Userrepository ur;
	
	//create
	public User registerUser(User user) {
		return ur.save(user);
	}
	
	//Read
	public List<User> getUsers(){
		return (List<User>)ur.findAll();
	}
	
	//update
	public User UpdateUser(Long id,User user) {
		User existingUser=ur.findById(id).orElse(null);
		
		if(existingUser!=null) {
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setDesignation(user.getDesignation());
			return ur.save(existingUser);
		}
		return null;
	}
	
	//Delete
	public String deleteUser(Long id) {
		if(ur.existsById(id)) {
		ur.deleteById(id);
		return "User deleted successfully";
	}
		return "User not found";
	
}
}
