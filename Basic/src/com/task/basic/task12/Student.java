package com.task.basic.task12;

public class Student {
	private int studentId;
	private String studentName;
	private char attendanceStatus;

	public int getStudentId() {
		return this.studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public char getAttendanceStatus() {
		return this.attendanceStatus;
	}

	public void setAttendanceStatus(char attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public Student(int studentId, String studentName, char attendanceStatus) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.attendanceStatus = attendanceStatus;
	}

	public void studentInfo() {
		System.out.println(this.studentId + "\t" + this.studentName + "\t" + this.attendanceStatus);

	}

}
