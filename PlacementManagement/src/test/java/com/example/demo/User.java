package com.example.demo;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class User 
{
	@Id
	private Integer user_id;
	private String user_name;
	private String user_password;
	

	//Default Constructor
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Parameterized Constructor 
	public User(Integer user_id, String user_name, String user_password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_password = user_password;
	}

	//getters and setters method
	public Integer getId() {
		return user_id;
	}

	public void setId(Integer id) {
		this.user_id = id;
	}

	public String getAdmin_name() {
		return user_name;
	}

	public void setAdmin_name(String admin_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String User_password) {
		this.user_password = user_password;
	}
	
	// toString Method
	@Override
	public String toString() {
		return "User [id=" + user_id + ", a_name=" +user_name + ", user_password=" + user_password + "]";
	}
}