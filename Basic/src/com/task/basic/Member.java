package com.task.basic;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private int memberId;
	private String name;
	private List<Book> borrowedBooks = new ArrayList<>();

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(Book book) {
		this.borrowedBooks.add(book);
	}

	public Member(int memberId, String name) {
		super();
		this.memberId = memberId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "MemberID :" + this.memberId + ", Name :" + this.name + "\n Borrowed Books:\n" + this.borrowedBooks
				+ "\n";
	}

	public void removeBook(int id) {
		this.borrowedBooks.remove(id);
	}

	public boolean checkBorrowedBook(int id) {
		for (Book b : this.borrowedBooks) {
			if (b.getBookId() == id) {
				return true;
			}
		}
		return false;
	}
}
