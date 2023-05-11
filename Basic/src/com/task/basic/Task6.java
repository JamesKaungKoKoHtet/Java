package com.task.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {
	private static float budget = 200000;
	private static List<Expense> myExpense = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// initialize data
		initializeData();
		// ask for input data for expense that are zero or less
		run();
		// calculate expense
		calculateExpense(myExpense);

	}

	// initialize data
	private static void initializeData() {
		myExpense.add(new Expense("house-rent", 0));
		myExpense.add(new Expense("phone-bill", 0));
		myExpense.add(new Expense("shopping", 0));
		myExpense.add(new Expense("electric-bill", 0));
		myExpense.add(new Expense("water-supply-bill", 0));
		myExpense.add(new Expense("gas-bill", 0));
	}

	// calculate expense by looping expense obj and deducting
	private static void calculateExpense(List<Expense> expense) {
		for (Expense e : expense) {
			budget = budget - e.getExpense();
		}
		System.out.println("\nYour Remaining Budget is " + budget + " yen");

	}

	// ask for input data for expense that are zero or less
	private static void run() {
		for (Expense e : myExpense) {
			if (e.getExpense() <= 0) {
				System.out.print("Enter expense for " + e.getName() + " :");
				try {
					System.out.println("try");

					e.setExpense(Float.parseFloat(sc.next()));
					System.out.println("try2");
				} catch (Exception e2) {
					run();
				}
			}
		}
	}

}
