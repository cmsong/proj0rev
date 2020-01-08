package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class UserDAOimpl implements UserDAO {
	public static Connection conn = com.revature.utilities.JDBCConnection.getConnection();
	
	public User getUser(String user) {
		try {
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();		
			while(rs.next())
			{
				return new User(
						rs.getString("username"), 
						rs.getString("pass"), rs.getInt("employee"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getAllUser() {
		String sql = "SELECT * FROM users";
		List<User> uList = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				uList.add(new User(
						rs.getString("username"), 
						rs.getString("pass"), rs.getInt("employee")));
			}
			return uList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uList;
	}

	public boolean addUser(String user, String pass) {
		String sql = "CALL add_new_cust(?, ?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, user);
			cs.setString(2, pass);
			cs.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public int checkCustPass(String user, String pword){
		String sql = "SELECT * FROM users WHERE username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				String pass = rs.getString("PASS");
				int check = rs.getInt("employee");
				if (pword.equals(pass) && check == 0)
					return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int checkEmpPass(String user, String pword){
		String sql = "SELECT * FROM users WHERE username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				String pass = rs.getString("PASS");
				int check = rs.getInt("employee");
				if (pword.equals(pass) && check == 1)
					return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
