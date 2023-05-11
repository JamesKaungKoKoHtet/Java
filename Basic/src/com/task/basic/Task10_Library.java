package com.task.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Task10_Library {
	static Scanner sc = new Scanner(System.in);
	static List<Book> books = new ArrayList<>();
	static List<Member> members = new ArrayList<>();

	public static void main(String[] args) {
		// Create Books
		books.add(new Book(1, "The Lord of the Rings", 0));
		books.add(new Book(2, "The Hobbit", 0));
		books.add(new Book(3, "Harry Potter and the Philisopher's Stone", 0));
		books.add(new Book(4, "Harry Potter and the Chamber of Secrets", 0));

		// Create Members
		members.add(new Member(1, "John"));
		members.add(new Member(2, "Mike"));
		System.out.println("Welcome to the Library Management system. Please choose an option:");

		start();

	}

	// display menu
	public static void initialDisplay() {
		System.out.println("1. Display All Books");
		System.out.println("2. Display All Members");
		System.out.println("3. Lend Book");
		System.out.println("4. Return Book");
		System.out.print("5. Exit\nEnter your choice:");
	}

	public static void start() {
		int userInput = 0;
		// call menu display
		initialDisplay();

		String srt = sc.nextLine();

		// use validate for user input data if return flase: proceed to start again
		if (validate(5, srt)) {
			selectOption(Integer.parseInt(srt));
		} else {
			System.out.println("Invalid choice. Please enter a number from 1-5.\n");
			start();
		}

	}

	public static void selectOption(int input) {

		switch (input) {
		case 1: {
			displayData(1);
			break;
		}
		case 2: {
			displayData(2);
			break;
		}
		case 3: {
			lendBook();
			break;
		}
		case 4: {
			returnBook();
			break;
		}
		case 5: {
			System.out.println("Exiting Library Management System. Goodbye!");
			sc.close();
			System.exit(0);
		}

		}

	}

	// method to loop obj and use toString
	public static void displayData(int check) {
		if (check == 1) {
			for (Book b : books) {
				System.out.println(b.toString());
			}
		} else if (check == 2) {
			for (Member m : members) {
				System.out.println(m.toString());
			}
		}
		System.out.println();
		start();

	}

	// validate input count : for desirable max digit , data : str to int
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

	public static void lendBook() {

		System.out.print("Enter book ID: ");
		String bookId = sc.nextLine();

		// Validate method return a boolean if input is not as intended
		if (validate(books.size(), bookId)) {

			// loop obj for specific bookId only
			for (Book b : books) {

				// check if looped obj id is the same with input data
				if (b.getBookId() == Integer.parseInt(bookId)) {

					memberLendBook(Integer.parseInt(bookId));
				}

			}
		} else {
			// validate failed
			System.out.println("Please enter correct bookID");
			lendBook();
		}

	}

	public static void memberLendBook(int bookId) {

		System.out.print("Enter member ID: ");
		String memberId = sc.nextLine();

		// Validate method return a boolean if input is not as intended
		if (validate(members.size(), memberId)) {

			int id = Integer.parseInt(memberId);

			for (Member m : members) {

				if (m.getMemberId() == id) {
					// check if member already has the book
					if (m.getBorrowedBooks().contains(books.get(bookId - 1))) {
						System.out.println("This member already borrowed this book");
					}

					else {
						// put the book obj into member's borrowed book
						m.setBorrowedBooks(books.get(bookId - 1));

						// set lendflag of the book to 1
						books.get(bookId - 1).setLendFlag(1);
						System.out.println("Thank you");
						start();
					}

				}
			}
		} else {
			// validate failed
			System.out.println("Please enter correct memberID");
			memberLendBook(bookId);
		}

	}

	public static void returnBook() {

		// checkBookStatus return true if no books are borrowed
		if (checkBookStatus()) {
			System.out.println("There are No Books that are borrowed\n");
			start();
		}
		System.out.print("Enter book ID: ");
		String bookId = sc.nextLine();

		// Validate method return a boolean if input is not as intended
		if (validate(books.size(), bookId)) {

			// loop obj for specific bookId only
			for (Book b : books) {
				// check if looped obj id is the same with input data
				if (b.getBookId() == Integer.parseInt(bookId)) {

					// check if lend flag is zero or not
					if (b.getLendFlag() == 0) {
						System.out.println("Your choise is not lended.");
						returnBook();// if all book is not lended this loop doesn't die :[
					} else {
						// continue to lend book to member , carry book id as parameter
						try {
							memberReturnBook(Integer.parseInt(bookId));
						} catch (NullPointerException e) {
							e.toString();
						}
					}
				}

			}
		} else {
			// validate failed
			System.out.println("Please enter correct bookID");
			returnBook();
		}

	}

	public static void memberReturnBook(int bookId) {

		System.out.print("Enter member ID: ");
		String memberId = sc.nextLine();

		// Validate method return a boolean if input is not as intended
		if (validate(members.size(), memberId)) {

			int id = Integer.parseInt(memberId);

			for (Member m : members) {

				if (m.getMemberId() == id && m.checkBorrowedBook(bookId)) {

					// removeBook method carry bookId as argument
					m.removeBook(bookId - 1); // remove the book from member's borrowed list
					books.get(bookId - 1).setLendFlag(0); // set lendflag of the book to 1
					System.out.println("Thank you");
					start();

				} else {
					// check borrowed Book return false;
					System.out.println("This member does not has a borrowed book");
					memberReturnBook(bookId);
				}
			}
		} else {
			// validate failed
			System.out.println("Please enter correct memberID");
			memberReturnBook(bookId);
		}

	}

	// check method that return true if none of the book is borrowed
	public static boolean checkBookStatus() {
		for (Book b : books) {
			if (b.getLendFlag() != 0) {
				return false;
			}
			break;
		}
		return true;
	}

}
