package com.fm.mybank.bank;

import java.util.ArrayList;
import java.util.List;

import com.fm.mybank.person.Client;

/*
 * Model class that represent bank
 * Holds a list with all clients
 * Method that add clients to list
 * Right now there is very little data in this class
 * This was just to learn more about object-oriented
 * programming and Java
 */
public class Bank {

	private String name, city;
	private List<Client> clientList;

	public Bank(String name, String city) {
		super();
		this.name = name;
		this.city = city;
		clientList = new ArrayList<Client>();
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	// Method that add clients to list
	public void addClient(Client newOwner) {
		clientList.add(newOwner);
	}

	@Override
	public String toString() {
		return "Bank | Name: " + name + " |\tCity: " + city + "\n\nList of Customers:\n\n" + clientList;
	}

}
