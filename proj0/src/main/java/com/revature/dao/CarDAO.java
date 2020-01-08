package com.revature.dao;
import java.util.List;

import com.revature.models.Car;

public interface CarDAO {
	public boolean addCar(Car c);
	public Car getCar(int c_id);
	public List<Car> getAllCar();
	public boolean addCar(String name, double price);
	public boolean removeCar(int c_id);
	public boolean changeOwner(int c_id, String user);
	public boolean setPrice(int c_id, double price);
	public List<Car> getOwnedCar(String name);
	public int getc_id(String name);
}
