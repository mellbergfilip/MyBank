package com.ya.mybank.bank;

import java.util.ArrayList;
import java.util.List;

import com.ya.mybank.person.Client;

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

	public void addClient(Client newOwner) {
		clientList.add(newOwner);
	}

	@Override
	public String toString() {
		return "Bank | Name: " + name + " |\tCity: " + city + "\n\nList of Customers:\n\n" + clientList;
	}

}
