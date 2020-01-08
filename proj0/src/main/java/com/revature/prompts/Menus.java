package com.revature.prompts;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Car;
import com.revature.models.Financials;
import com.revature.service.CarService;
import com.revature.service.FinancialsService;

public class Menus {
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	public static Scanner sc = new Scanner(System.in);
	public static void cmenu(String user) {
		System.out.println("-------Customer Menu-------"
				+ "\n1. View cars on lot\n2. Make an offer\n3. View owned cars\n4. View remaining payments\n5. Logout");
		String input = sc.nextLine();
		int i = Integer.parseInt(input);
		switch(i)
		{
		case 1:
			StartUp.displaylot();
			cmenu(user);
			break;
		case 2:
			StartUp.displaylot();
			System.out.println("Enter the ID of the car you would like to make an offer on: ");
			int in = Integer.parseInt(sc.nextLine());
			System.out.println("Enter offer price: ");
			double off = Double.parseDouble(sc.nextLine());
			FinancialsService.makeOffer(in, user, off);
			cmenu(user);
			break;
		case 3:
			List<Car> owned = CarService.getOwnedCar(user);
			System.out.println(owned);
			cmenu(user);
			break;
		case 4:
			List<Financials> lfin = FinancialsService.custViewPayments(user);
			List<Financials> lfincop = new ArrayList<Financials>();
			lfincop = lfin;
			for (int y = 0; y < lfin.size(); y++)
			{
				System.out.println("\nFor " + CarService.getCar(lfincop.get(y).getC_id()).getModel());
				System.out.print("  you owe a monthly payment of $" + df2.format(lfincop.get(y).getOfferPrice()/60) + 
						" for the next 60 months\n");
			}
			cmenu(user);
			break;
		case 5:
			StartUp.menu();
			break;
		}
	}
	public static void emenu(String user) {
		System.out.println("-------Employee Menu-------"
				+ "\n1. Add car to the lot\n2. Accept offer\n3. Reject an offer"
				+ "\n4. Remove car from lot\n5. View payments\n6. Logout");
		String input = sc.nextLine();
		int i = Integer.parseInt(input);
		switch(i)
		{
		case 1:
			System.out.println("Enter year, make, and model:");
			String name = sc.nextLine();
			System.out.println("Enter price:");
			Double price = Double.parseDouble(sc.nextLine());
			CarService.addCar(name, price);
			System.out.println(name + " added successfully!");
			emenu(user);
		case 2:
			FinancialsService.viewOffers();
			System.out.println("Enter the ID of the car you would like to accept an offer on: ");
			int in = Integer.parseInt(sc.nextLine());
			System.out.println("Enter customer name: ");
			String un = sc.nextLine();
			FinancialsService.acceptOffer(in, un);
			CarService.setPrice(in, FinancialsService.getOffer(in, un).getOfferPrice());
			FinancialsService.rejectOtherOffers(in, un);
			emenu(user);
			break;
		case 3:
			FinancialsService.viewOffers();
			System.out.println("Enter the ID of the car you would like to reject an offer on: ");
			int in2 = Integer.parseInt(sc.nextLine());
			System.out.println("Enter customer name: ");
			String un2 = sc.nextLine();
			FinancialsService.rejectOffer(in2, un2);
			emenu(user);
			break;
		case 4:
			StartUp.displaylot();
			System.out.println("Enter ID of car to remove:");
			int c_id = Integer.parseInt(sc.nextLine());
			FinancialsService.removeAllOffer(c_id);
			CarService.removeCar(c_id);	
			System.out.println("Car removed");
			emenu(user);
			break;
		case 5:
			List<Financials> finan = FinancialsService.empViewPayments();
			List<Financials> lfincop2 = new ArrayList<Financials>();
			lfincop2 = finan;
			for (int y = 0; y < finan.size(); y++)
			{
				System.out.println("\nFor " + CarService.getCar(lfincop2.get(y).getC_id()).getModel());
				System.out.print(lfincop2.get(y).getUser() + " owes 60 monthly payments of $" + (Math.round(lfincop2.get(y).getOfferPrice()/60.0 * 100.0)/100.00 + 
						"\n"));
			}
			emenu(user);
			break;
		case 6:
			StartUp.menu();
			break;
		}
	}
}
