package com.revature.models;

public class Financials {
	private int c_id;
	private String user;
	private double offer;
	private int status;
	
	public Financials(int c_id, String user, double offer) {
		super();
		this.c_id = c_id;
		this.user = user;
		this.offer = offer;
		this.status = 0;
	}
	@Override
	public String toString() {
		return "\n\tCar ID:" + c_id + "   " + user + "    $" + offer;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public double getOfferPrice() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
