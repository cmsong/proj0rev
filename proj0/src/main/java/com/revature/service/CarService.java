package com.revature.service;

import java.util.List;

import com.revature.dao.CarDAO;
import com.revature.dao.CarDAOimpl;
import com.revature.models.Car;

public class CarService {
	public static CarDAO cd = new CarDAOimpl();
	
	public static boolean addCar(Car c) {
		return cd.addCar(c);
	}
	public static Car getCar(int c_id) {
		return cd.getCar(c_id);
	}
	public static List<Car> getAllCar(){
		return cd.getAllCar();
	}
	public static boolean addCar(String name, double price) {
		return cd.addCar(name, price);
	}
	public static List<Car> getOwnedCar(String s){
		return cd.getOwnedCar(s);
	}
	public static boolean setPrice(int c_id, double price) {
		return cd.setPrice(c_id, price);
	}
	public static boolean removeCar(int c_id) {
		return cd.removeCar(c_id);
	}
	public static int getc_id(String name) {
		return cd.getc_id(name);
	}
}
