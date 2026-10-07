package com.example.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingmall.entity.User;
import com.example.shoppingmall.service.Userservice;

@CrossOrigin(origins="http://localhost:3000")
@RestController
//to use the rest APIs
public class Usercontroller {
	
	@Autowired
	private Userservice us;
	
	//create
	@PostMapping("/adduser")
	public User registerUser(@RequestBody User user) {
		return us.registerUser(user);
	}
	
	//Read
	@GetMapping("/getuser")
	public List<User> getUsers(){
		return us.getUsers();
	}
	
	//update
	@PutMapping("/updateuser/{id}")
	public User updateUser(@PathVariable("id") Long id,@RequestBody User user) {
		return us.UpdateUser(id, user);
	}
	
	//Delete
	@DeleteMapping("/deleteuser/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		return us.deleteUser(id);
	}
	

}
