package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Financials;

public class FinancialsDAOimpl implements FinancialsDAO{
	public static Connection conn = com.revature.utilities.JDBCConnection.getConnection();
	public boolean makeOffer(int c_id, String user, double price) {
		String sql = "CALL add_new_offer(?, ?, ?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(1, c_id);
			cs.setString(2, user);
			cs.setDouble(3,  price);
			cs.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean acceptOffer(int c_id, String user) {
		String sql = "Call accept_offer(?, ?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, user);
			cs.setInt(2,  c_id);
			cs.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Financials> viewOffers() {
		String sql = "SELECT * FROM financials WHERE status = 0";
		List<Financials> offList = new ArrayList<Financials>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				offList.add(new Financials(
						rs.getInt("c_id"), rs.getString("u_id"),
						rs.getDouble("offerprice")));
			}
			System.out.println(offList);
			return offList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offList;
	}
	
	public List<Financials> custViewPayments(String user) {
		String sql = "SELECT * FROM financials WHERE status = 1 AND u_id = ?";
		List<Financials> offList = new ArrayList<Financials>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				offList.add(new Financials(
						rs.getInt("c_id"), rs.getString("u_id"),
						rs.getDouble("offerprice")));
			}
			return offList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offList;
	}

	public boolean rejectOtherOffers(int c_id, String user) {
		String sql = "DELETE FROM financials WHERE c_id = ? AND u_id != ?";
		
		try {
			CallableStatement ps = conn.prepareCall(sql);
			ps.setInt(1, c_id);
			ps.setString(2, user);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean rejectOffer(int c_id, String user) {
		String sql = "Call reject_offer(?, ?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, user);
			cs.setInt(2,  c_id);
			cs.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Financials getOffer(int c_id, String user) {
		String sql = "SELECT * FROM financials where c_id = ? and u_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c_id);
			ps.setString(2, user);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Financials(rs.getInt("c_id"), 
						rs.getString("u_id"),
						rs.getDouble("offerprice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Financials> empViewPayments() {
		String sql = "SELECT * FROM financials WHERE status = 1";
		List<Financials> olist = new ArrayList<Financials>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				olist.add(new Financials(
						rs.getInt("c_id"), rs.getString("u_id"),
						rs.getDouble("offerprice")));
			}
			return olist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return olist;
	}
	public boolean removeAllOffer(int c_id) {
		String sql = "DELETE FROM financials WHERE c_id = ?";
		
		try {
			CallableStatement ps = conn.prepareCall(sql);
			ps.setInt(1, c_id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
