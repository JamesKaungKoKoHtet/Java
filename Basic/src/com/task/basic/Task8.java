package com.task.basic;

import java.util.Random;
import java.util.Scanner;

public class Task8 {
	static Scanner sc = new Scanner(System.in);
	static boolean gameover = true;

	public static void main(String[] args) {

		System.out.print("Get the number between 0 and 9\nInput A number between 0 and 9:");
		play(sc.nextLine());
	}

	// method for random number generation
	public static int generate() {
		Random rnd = new Random();
		int check = rnd.nextInt(9);
		System.out.println("Random number is : " + check);
		return check;
	}

	// method for game over checkpoint : call itself until valid answer
	public static void gameover(String check) {
		switch (check) {
		case "yes":
			System.out.print("Get the number between 0 and 9\nInput A number between 0 and 9:");
			play(sc.nextLine());

		case "no":
			System.out.println("Good Luck Next Time!!!");
			sc.close();
			System.exit(0);

		default:
			System.out.print("Sorry! Would you like to try again? (yes/no) :\n");

			gameover(sc.nextLine());
		}

	}

	// method for main play function : call itself until game over
	public static void play(String input) {

		int int1 = 0;
		if (input.length() > 1) {
			System.out.print("Please input number not more than 1 line: ");
			play(sc.nextLine());
		}

		try {
			int1 = Integer.parseInt(input);
			if (int1 == generate()) {
				System.out.println("Congratulation");
			} else {

				System.out.print("Sorry! Would you like to try again? (yes/no) : ");

				gameover(sc.nextLine());
			}

		} catch (Exception e) {

			System.out.print("Please input number : ");
			play(sc.nextLine());
		}
	}

}
