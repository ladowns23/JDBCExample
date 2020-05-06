package com.lad.labs;

import java.io.Serializable;

//This is a valid bean
public class Employee implements Serializable {
	private static final long serialVersionUID = -1488284677006497519L;
	long id;
	String firstName;
	String lastName;
	int deptId;
	int credits;

	Employee() {
	
	}

	Employee(long id, String firstName, String lastName, int deptId, int credits) {
		this.setId(id);
		this.setCredits(credits);
		this.setDeptId(deptId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	long getId() {
		return id;
	}

	String getFirstName() {
		return firstName;
	}

	String getLastName() {
		return lastName;
	}

	int getDeptId() {
		return deptId;
	}

	int getCredits() {
		return credits;
	}

	void setId(long id) {
		this.id = id;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	void setCredits(int credits) {
		this.credits = credits;
	}

}
