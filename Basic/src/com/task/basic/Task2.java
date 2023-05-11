package com.task.basic;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

	public static void main(String[] args) {

		// declare students
		List<Student> myList = new ArrayList<>();
		myList.add(new Student("MgMg", "Class-A", 15, "male"));
		myList.add(new Student("KgKg", "Class-A", 16, "male"));
		myList.add(new Student("AyeAye", "Class-B", 13, "female"));

		// console output
		for (Student e : myList) {
			System.out.println(e.toString());
		}

	}
}
