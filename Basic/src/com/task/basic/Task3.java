package com.task.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
	static String validationYesNo = "[yn]|yes|no";
	static Scanner sc = new Scanner(System.in);
	static List<Items> vendingMach1 = new ArrayList<>();
	static List<Integer> itemsCanBuy = new ArrayList<>();
	static double userCash = 0;

	public static void main(String[] args) {

		// initializing item data
		initializeData();

		// display all items in vending machine
		displayItems();

		// check user input data and set affordable items
		inputCash();

		// display items that user can afford
		// check user input and buy
		buy();

	}

	// declare items
	public static void initializeData() {

		vendingMach1.add(new Items(1, "Tea", 190));
		vendingMach1.add(new Items(2, "Pure Water", 100));
		vendingMach1.add(new Items(3, "Pepsi", 130));
		vendingMach1.add(new Items(4, "Coffee", 150));
		vendingMach1.add(new Items(5, "Energy Drink", 220));
	}

	// deduct item price from userCash
	public static void calculate(int id) {
		for (Items i : vendingMach1)
			if (id == i.getid()) {
				userCash -= i.getPrice();
			}
	}

	// print Thank you with cash change if remained
	public static void exit() {
		System.out.println(userCash > 0 ? "Thank you! Your change is: " + userCash : "Thank you!");
		sc.close();
		System.exit(1);
	}

	// validate integer
	public static int validate() {
		try {
			return sc.nextInt();
		} catch (Exception e) {
			return -1;
		}

	}

	// return cashData if true double : else return -1
	public static double validateCash() {
		try {
			return sc.nextDouble();
		} catch (Exception e) {
			return -1;
		}
	}

	// validate y/n
	public static void validateYesNo() {
		System.out.println("Would you like to buy more ? (y/n)");
		switch (sc.nextLine().toLowerCase().trim()) {
		case "y", "yes": {
			buy();
			break;
		}
		case "n", "no": {
			exit();
		}
		default:
			validateYesNo();
		}

	}

	// display all items
	public static void displayItems() {
		for (Items i : vendingMach1) {
			System.out.println(i.toString());
		}
		System.out.println();
	}

	// display Items that user can afford
	public static void displayItems(double data) {
		System.out.println("\nYour cash :" + userCash);
		for (Items i : vendingMach1) {
			if (data >= i.getPrice())
				System.out.println(i.toString());
		}
		System.out.print("\nPlease input your item to buy :");
	}

	public static void inputCash() {

		System.out.print("Please input your cash :");
		userCash = validateCash();

		// validated data return userCash : greater than zero if input was correct
		if (userCash > 0) {
			setBuyItems();
		}
		// if userCash is -1 then call start again
		else {
			System.out.println("Please input your valid cash");
			inputCash();
		}

	}

	// check userCash and set affordable items
	public static void setBuyItems() {
		itemsCanBuy.clear();
		for (Items itms : vendingMach1) {
			if (userCash >= itms.getPrice()) {
				itemsCanBuy.add(itms.getid());
			}
		}

	}

	// check affordable item list , 
	public static void buy() {

		// exit if cash is not enough ? or should ask for more cash?
		// usually items are chosen first
		if (itemsCanBuy.size() < 1) {
			System.out.println("Your Cash is not enought !");
			exit();
		}
		
		displayItems(userCash);
		int itemId = validate();

		if ((itemId > 0) && itemsCanBuy.contains(itemId)) {
			calculate(itemId);
			setBuyItems();
			buyAgain();
		} else {
			System.out.println("Please choose valid item!\n");
			buy();
		}
	}

	// Ask continue if remaining cash can afford an item otherwise show Thank you
	public static void buyAgain() {
		if (itemsCanBuy.size() > 0) {
			validateYesNo();
		} else {
			exit();
		}
	}

}
