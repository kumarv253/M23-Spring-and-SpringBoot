package com.example.demo;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService 
{
	@Autowired
	private UserRepository user_repo;
	
	// To retrieve all the data of user class
	public List<User> listAll()
	{
		return user_repo.findAll();
	}
	
	// insert/update a data
	public void create(User a)
	{
		user_repo.save(a);
	}
	
	// to retrieve a single record
	public User retrieve(Integer user_id)
	{
		return user_repo.findById(user_id).get();			
	}
	
	// to delete a data
	public void delete(Integer user_id)
	{
		user_repo.deleteById(user_id);
	}
}