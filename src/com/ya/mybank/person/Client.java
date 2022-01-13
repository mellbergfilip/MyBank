package com.ya.mybank.person;

import com.ya.mybank.account.BankAccount;

public class Client extends Person {

	BankAccount account;
	int clientNr;

	public Client(String firstName, String lastName) {
		super(firstName, lastName);
		account = new BankAccount();
	}

	// Constructor used for premaking clients
	public Client(String firstName, String lastName, int clientNr, String AccountNr) {
		super(firstName, lastName);
		this.clientNr = clientNr;
		account = new BankAccount(AccountNr);
	}

	public BankAccount getAccount() {
		return account;
	}

	public int getClientNr() {
		return clientNr;
	}
	
	public void setClientNr(int clientNr) {
		this.clientNr = clientNr;
	}

	@Override
	public String toString() {
		return "\n------------------------------------------------\n" + "Name: " + getFirstName() + " " + getLastName()
				+ "\t|\tClientNumber: " + clientNr + "\n" + account
				+ "\n-------------------------------------------------\n";
	}

}
