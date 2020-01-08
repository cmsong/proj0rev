package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOimpl;
import com.revature.models.User;

public class UserService {
	public static UserDAO ud = new UserDAOimpl();
	
	public static User getUser(String user) {
		return ud.getUser(user);
	}
	
	public static List<User> getAllUser() {
		return ud.getAllUser();
	}
	public static boolean addUser(String user, String pass) {
		return ud.addUser(user, pass);
	}
	public static int checkCustPass(String user, String pword) {
		return ud.checkCustPass(user, pword);
	}
	public static int checkEmpPass(String user, String pword) {
		return ud.checkEmpPass(user, pword);
	}
}
