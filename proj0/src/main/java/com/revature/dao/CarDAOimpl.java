package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Car;

public class CarDAOimpl implements CarDAO{
	public static Connection conn = com.revature.utilities.JDBCConnection.getConnection();
	
	public boolean addCar(Car c)
	{
		try {
			String sql = "Call add_new_car(?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, c.getModel());
			cs.setDouble(2, c.getPrice());
			cs.execute();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Car getCar(int c_id) {
		try {
			String sql = "SELECT * FROM cars WHERE c_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Car(
						rs.getString("cmodel"), 
						rs.getDouble("price"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Car> getAllCar() {
		String sql = "SELECT * FROM cars WHERE owner = 'lot'";
		List<Car> carList = new ArrayList<Car>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				carList.add(new Car(
						rs.getInt("c_id"), rs.getString("cmodel"),
						rs.getDouble("price")));
			}
			return carList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carList;
	}

	public boolean addCar(String name, double price) {
		String sql = "CALL add_new_car(?, ?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, name);
			cs.setDouble(2, price);
			cs.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Car> getOwnedCar(String user) {
		String sql = "SELECT * FROM cars WHERE owner = ?";
		List<Car> carList = new ArrayList<Car>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				carList.add(new Car(
						rs.getInt("c_id"), rs.getString("cmodel"),
						rs.getDouble("price")));
			}
			return carList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carList;
	}

	public boolean changeOwner(int c_id, String user) {
		String sql = "UPDATE cars SET owner= ? WHERE c_id = ?";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, user);
			cs.setDouble(2, c_id);
			cs.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean setPrice(int c_id, double price) {
		String sql = "UPDATE cars SET price = ? where c_id = ?";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setDouble(1, price);
			cs.setInt(2, c_id);
			cs.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean removeCar(int c_id) {
		String sql = "DELETE FROM cars where c_id = ?";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, c_id);
			cs.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public int getc_id(String name) {
		String sql = "SELECT * FROM cars where cmodel = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return rs.getInt("c_id");
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
}
