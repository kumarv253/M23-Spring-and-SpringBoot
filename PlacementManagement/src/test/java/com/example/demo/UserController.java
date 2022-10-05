package com.example.demo;

import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	@Autowired
	private UserService user_service;
	
	//creation
	@PostMapping("/user")
	public void add(@RequestBody User a)
	{
		user_service.create(a);
	}
	
	// Deletion
	@DeleteMapping("/user/{user_id}")
	public void remove(@PathVariable Integer user_id)
	{
		user_service.delete(user_id);
	}
	
	//Retrieve All Data
	@GetMapping("/user")
	public List<User> list()
	{
		return user_service.listAll();	
	}
	
	//Retrieve with specific id
	@GetMapping("/user/{user_id}")
	public ResponseEntity<User> get(@PathVariable Integer user_id)
	{
		try
		{
			User a = user_service.retrieve(user_id);
			return new ResponseEntity<User>(a,HttpStatus.OK);	
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	// Update data for specific id
	@PutMapping("/user/{user_id}")
	public ResponseEntity<User> update(@RequestBody User a,@PathVariable Integer user_id)
	{
		try
		{
			@SuppressWarnings("unused")
			User a1 = user_service.retrieve(user_id);
			user_service.create(a);
			return new ResponseEntity<User>(a,HttpStatus.OK);	
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);			}
		}	
}