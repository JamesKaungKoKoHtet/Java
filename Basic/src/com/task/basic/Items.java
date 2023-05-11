package com.task.basic;

public class Items {
	private int id;
	private String item;
	private float price;

	public int getid() {
		return this.id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Items(int id, String item, float price) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
	}

	@Override
	public String toString() {
		return this.id + " " + this.item + " (" + this.price + "yen)";
	}

	public String toString2() {
		return this.item + " (" + this.price + "yen)";
	}

}
