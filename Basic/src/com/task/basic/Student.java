package com.task.basic;

public class Student {

	private String name;
	private String className;
	private int age;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Student(String name, String className, int age, String gender) {
		super();
		this.name = name;
		this.className = className;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [name=" + this.name + ", className=" + this.className + ", age=" + this.age + ", gender="
				+ this.gender + "]";
	}

}
