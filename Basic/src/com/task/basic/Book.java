package com.task.basic;

public class Book {
	private int bookId;
	private String title;
	private int lendFlag;

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLendFlag() {
		return this.lendFlag;
	}

	public void setLendFlag(int lendFlag) {
		this.lendFlag = lendFlag;
	}

	public Book(int bookId, String title, int lendFlag) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.lendFlag = lendFlag;
	}

	@Override
	public String toString() {
		return "BookId:" + this.bookId + ", Title :" + this.title+"\n"+this.lendFlag ;
	}
}
