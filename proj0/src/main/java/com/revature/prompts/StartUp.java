package com.revature.prompts;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Car;
import com.revature.models.User;
import com.revature.service.CarService;
import com.revature.service.UserService;
import com.revature.utilities.JDBCConnection;
import com.revature.utilities.MyLogger;

public class StartUp {
	static Connection conn = JDBCConnection.getConnection();
	static Scanner sc = new Scanner(System.in);
	static String mainmenu = "Welcome to Generic Car Dealer!\n1. Customer Login\n2. Employee Login\n3. "
			+ "View cars on lot\n4. Register new customer account\n5. Exit";
	
	public static void menu() {
		System.out.println(mainmenu);
		int i = Integer.parseInt(sc.nextLine());
		switch(i)
		{
		case 1:
			clogin();
			break;
		case 2:
			elogin();
			break;
		case 3:
			displaylot();
			menu();
			break;
		case 4:
			User newU = createcust();
			Menus.cmenu(newU.getUname());;
		case 5:
			System.out.println("Goodbye!");
			System.exit(0);
			break;
		}
		System.out.println();
		sc.close();
	}
	public static User createcust() {
		System.out.println("New customer username: ");
		String user = sc.nextLine();
		System.out.println("Choose password: ");
		String pass = sc.nextLine();
		UserService.addUser(user, pass);
		return UserService.getUser(user);
	}
	public static int checkCustLogin(String user, String pass)
	{
		if (UserService.checkCustPass(user, pass) == 1) 
			return 1;
		return 0;
	}
	public static int clogin() {
		System.out.println("Customer username: ");
		String user = sc.nextLine();
		System.out.println("Password: ");
		String pass = sc.nextLine();
		if(checkCustLogin(user, pass) == 1)
		{
			MyLogger.logger.info("Successfully entered customer credentials");
			System.out.println("Welcome " + user);
			Menus.cmenu(user);
		}
		else
			System.out.println("Incorrect login credentials!");
		menu();
		return 1;
	}
	public static int checkEmpLogin(String user, String pass)
	{
		if(UserService.checkEmpPass(user, pass) == 1) {
			MyLogger.logger.info("Successfully entered employee credentials");
			System.out.println("Welcome, employee of the year");
			Menus.emenu(user);
		}
		else
			System.out.println("Incorrect login credentials!");
			menu();
		return 1;
	}
	public static int elogin() {
		System.out.println("Employee username: ");
		String user = sc.nextLine();
		System.out.println("Password: ");
		String pass = sc.nextLine();
		checkEmpLogin(user, pass);
		return 1;
	}
	public static void displaylot() {
		List<Car> lot = CarService.getAllCar();
		System.out.println(lot);
	}
	
	
}
