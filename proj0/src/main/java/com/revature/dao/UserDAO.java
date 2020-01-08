package com.revature.dao;
import java.util.List;

import com.revature.models.User;

public interface UserDAO {
	//CRUD operations for your Model
	//CREATE - add
	//READ - get
	//UPDATE
	//DELETE
	
	public User getUser(String name);	
	public List<User> getAllUser();
	public boolean addUser(String user, String pass);
	public int checkCustPass(String user, String pword);
	public int checkEmpPass(String user, String pword);
}
