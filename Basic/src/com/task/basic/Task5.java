package com.task.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task5 {
	// declare reg validation string
	static String validate = "^\\d{2}/\\d{2}/\\d{4}$";
	// declare today date
	static LocalDate today = LocalDate.now();
	// declare user input date of birth
	static Date dob = new Date();
	static String input = "";
	// declare scanner and simple date format
	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		System.out.println("Please input your Date of Birth : (dd/mm/yyyy)");
		// call start method
		start();
		getAge();

	}

	// validate user input and call itself incase of error
	static void start() {
		System.out.print("Date of Birth :");
		input = sc.nextLine();
		if (input.matches(validate)) {
			try {
				dob = simpleDateFormat.parse(input);
			} catch (ParseException e) {
				System.err.println("Please input valid date");
				start();
			}
		} else {
			System.err.println("Please input valid date");
			start();
		}
	}

	// create calendar obj and calculate age by deducting dob from current time
	public static void getAge() {
		// create calendar object
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dob);

		// declare year and calculate

		int dobYear = calendar.get(Calendar.YEAR);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		int age = currentYear - dobYear;
		System.out.println(age + " Years old.");
	}

//	static void getAge(String input) {
//		LocalDate today = LocalDate.now();
//		LocalDate birthday = LocalDate.parse(input);
//		// date between now and dob resulting in negetive values
//		Period period = Period.between(today, birthday);
//
//	}

}
