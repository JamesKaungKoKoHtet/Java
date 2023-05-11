package com.task.basic;

public class Expense {

	private float expense;
	private String name;
	public Expense(String name ,float expense) {
		super();
		this.expense = expense;
		this.name = name;
	}
	public float getExpense() {
		return expense;
	}
	public void setExpense(float expense) {
		this.expense = expense;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
