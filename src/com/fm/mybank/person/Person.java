package com.fm.mybank.person;

/*
 * Abstract model class that represents Person
 * Baseclass to Client
 * Right now there is very little data in this class
 * This was just to learn more about object-oriented
 * programming and Java
 */
public abstract class Person {

	private String firstName;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
