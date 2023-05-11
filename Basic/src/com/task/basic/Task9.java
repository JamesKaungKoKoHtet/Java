package com.task.basic;

import java.util.Scanner;

public class Task9 {
	static Scanner sc = new Scanner(System.in);
	static boolean rooms[] = new boolean[10];
	static boolean exit = false;

	public static void main(String[] args) {
		initializeRooms();
		System.out.println(rooms.length);
		// do while loop for exit check
		do {
			displayOptions();
			switch (sc.nextLine()) {
			case "2":
				cancelBooking();
				break;
			case "4":
				exit();
				sc.close();
				break;
			case "3":
				displayBookings();
				break;
			case "1":
				bookRoom();
				break;
			default:
				showErrorMessage();
			}

		} while (!exit);

	}

	// method for exit : setting boolean check -> true
	public static void exit() {
		System.out.println("Existing Hotel Booking System. Goodbye!");
		exit = true;
	}

	// method for Room status display
	public static void displayBookings() {
		// display i+1 as room id due to using array for rooms
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i] == true) {
				System.out.println("Room " + (i + 1) + " : Open");
			} else {
				System.out.println("Room " + (i + 1) + " : Booked");
			}
		}
		System.out.println();
	}

	// method for main menu option display
	public static void displayOptions() {
		System.out.println("\nWelcome to Hotel Booking System!");
		System.out.println("1. Book a room");
		System.out.println("2. Cancel booking");
		System.out.println("3. Display bookings");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");

	}

	// method for setting room status to true : called once
	public static void initializeRooms() {
		for (int i = 0; i < rooms.length; i++) {
			rooms[i] = true;
		}

	}

	// room Booking method , user "input-1" due to using array for room id
	public static void bookRoom() {
		System.out.print("\nPlease enter the room number you want to book (1-10) :");
		try {
			// catch the error when user input data other than int
			int input = Integer.parseInt(sc.nextLine());
			// validate input data with room length
			if (input - 1 > rooms.length) {
				System.out.println("Please choose valid room number");
				bookRoom();
			}
			// rooms array is boolean if data inside is true then it is ok to book the room
			else if (rooms[input - 1]) {
				System.out.println("Booking successful! Thank you for choosing our hotel.");
				rooms[input - 1] = false;
			} 
			// preventing booking of rooms that are already booked
			else {
				System.out.println("The room is already booked, please choose another room.");
				bookRoom();
			}

		} catch (Exception e) {// catching user input error
			System.out.println("Please choose valid room number");
			bookRoom();
		}
	}
	// cancel Booking method , user "input-1" due to using array for room id
	public static void cancelBooking() {
		System.out.print("\nPlease enter the room number you want to cancel (1-10) :");
		try {
			// catch the error when user input data other than int
			int input = Integer.parseInt(sc.nextLine());
			
			// validate input data with room length
			if (input - 1 > rooms.length) {
				System.out.println("Please choose valid room number");
				cancelBooking();
			} 
			// rooms array is boolean if data inside is false then it is ok to cancel the room
			else if (!rooms[input - 1]) {
				System.out.println("Booking cancelled successfuliy! Thank you for choosing our hotel.");
				rooms[input - 1] = true;
			}
			// preventing cancellation of rooms that are not booked
			else {
				System.out.println("The room is not booked, please enter valid room number");
				displayBookings();
			}

		} catch (Exception e) { // catching user input error
			System.out.println("Please choose valid room number");
			cancelBooking();
		}
	}

	// print error string
	public static void showErrorMessage() {
		System.out.println("Invalid choice, please try again.");
	}
}
