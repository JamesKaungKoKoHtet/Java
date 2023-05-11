package com.task.basic.task12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task12 {
	

	static String path = "C:/Users/ASUS/Desktop/attendance.txt";
	static List<Student> students = new ArrayList<Student>();

	public static void main(String[] args) {

		start();

	}

	// Initial menu display
	public static void initialDisplay() {
		System.out.println("Welcome to Student Attendacen Management System. Please choose an option:");
		System.out.println("1. View all students' attendance\n2. Mark attendance\n3. Exit\nEnter your choice:");
	}

	public static boolean validate(int count, String data) {
		try {
			int checkData = Integer.parseInt(data);
			if (checkData > count || checkData == 0) {
				throw new Exception();
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public static void start() {
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		// call menu display
		initialDisplay();

		String srt = sc.nextLine();

		// use validate for user input data if return flase: proceed to start again
		if (validate(3, srt)) {
			selectOption(Integer.parseInt(srt));
		} else {
			System.out.println("Invalid choice. Please enter a number from 1-3.\n");
			start();
		}

	}

	public static void selectOption(int input) {
		switch (input) {
		case 1: {
			readData();
			break;
		}
		case 2: {
			markAttendance();
			break;
		}
		case 3:
			exit();

		}

	}

	public static void readData() {
		students.clear();
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(" ");

				int studentId = Integer.parseInt(parts[0]);
				String studentName = parts[1];
				char attendanceStatus = parts[2].charAt(0);
				Student student = new Student(studentId, studentName, attendanceStatus);
				students.add(student);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
			start();
		}

		System.out.println("Id\tName\tAttendance Status");
		for (Student student : students) {
			student.studentInfo();
		}
		System.out.println("");
		start();
	}

	public static void markAttendance() {
		Scanner sc2 = new Scanner(System.in);
		if (students.size() == 0) {
			System.out.println("Please view Student attendance status first");
			start();
		} else {
			System.out.println(students.size());
		}

		System.out.print("Enter the student ID:");
		String srt = sc2.nextLine();

		if (validate(students.size(), srt)) {
			System.out.print("Enter the attendance status (p or a):");
			switch (sc2.nextLine().toLowerCase()) {
			case "p": {
				students.get(Integer.parseInt(srt) - 1).setAttendanceStatus('p');
				break;
			}
			case "a": {
				students.get(Integer.parseInt(srt) - 1).setAttendanceStatus('a');
				break;
			}

			}
			System.out.println("Id\tName\tAttendance Status");
			for (Student student : students) {
				student.studentInfo();
			}
			updateFileData();
			start();

		} else {
			System.out.println("Please enter correct studentID");
			markAttendance();
		}

	}

	public static void updateFileData() {
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			for (Student student : students) {
				System.out.println("looped");
				bw.write(student.getStudentId() + " " + student.getStudentName() + " " + student.getAttendanceStatus()
						+ "\n");
			}

			bw.close();
			fw.close();

			System.out.println("Attendance data has been written to file.");
		} catch (IOException e) {
			System.out.println("Error update file");
		}
	}

	public static void exit() {
		System.out.println("Existing Student Management System. Goodbye!");
		System.exit(1);
	}

}
