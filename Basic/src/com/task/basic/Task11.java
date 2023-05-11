package com.task.basic;

import java.util.Scanner;

public class Task11 {
	static Scanner sc = new Scanner(System.in);
	static String string = "\n";

	public static void main(String[] args) {
		// initial display
		System.out.println("Welcome to Area and Perimeter Calculator.");

		// call create methods for shapes
		createCircle();
		createRectangle();

		// output result and exit
		System.out.println(string);
		System.exit(1);
	}

	public static void createCircle() {
		// validation needed
		System.out.print("Enter the radius of the circle:");
		Circle circle = new Circle(sc.nextDouble());
		// add result into string : can write toString method
		string += "Area of circle :" + circle.getArea() + "\n";
		string += "Perimeter of circle :" + circle.getPerimeter() + "\n";
	}

	public static void createRectangle() {
		// validation needed
		System.out.print("Enter the width of the rectengle : ");
		double width = sc.nextDouble();
		System.out.print("Enter the height of the rectengle : ");
		double length = sc.nextDouble();

		Rectangle rectangle = new Rectangle(length, width);
		// add result into string : can write toString method
		string += "Area of rectangle :" + rectangle.getArea() + "\n";
		string += "Perimeter of rectangle :" + rectangle.getPerimeter() + "\n";
	}

}
