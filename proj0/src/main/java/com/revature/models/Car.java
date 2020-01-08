package com.revature.models;

public class Car {
	
	private String cModel;
	private int c_id;
	private double price;
	
	@Override
	public String toString() {
		return "\nID: " + c_id + "    Model: " + cModel + 
				"      Price: $" + (Math.round(price * 100.00))/100;
	}
	public Car(String cModel, double price)
	{
		this.cModel = cModel;
		this.price = price;
	}
	public Car(int c_id, String cModel, double price) {
		this.c_id = c_id;
		this.cModel = cModel;
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getModel() {
		return cModel;
	}
	
	public int getId() {
		return c_id;
	}
}
