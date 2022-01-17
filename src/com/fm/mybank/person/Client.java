package com.fm.mybank.person;

import java.util.ArrayList;
import java.util.List;

import com.fm.mybank.account.BankAccount;
import com.fm.mybank.account.CheckingAccount;

/*
 * Model class that represent Client
 * Subclass to Person
 * Extends all methods & variables from Person
 * Holds list with clientaccounts
 * Method that add accounts to accountlist
 * Right now there is very little data in this class
 * This was just to learn more about object-oriented
 * programming and Java
 */
public class Client extends Person {

	private List<BankAccount> accountList = new ArrayList<BankAccount>();
	private int clientNr;

	/*
	 * Constructor that takes in firstName and lastName as parameters
	 * Used for client registration
	 */
	public Client(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	/*
	 * Constructor used for premaking clients takes firstName,lastName, clientNr &
	 * accountNr as parameters
	 */
	public Client(String firstName, String lastName, String accountNr) {
		setFirstName(firstName);
		setLastName(lastName);
		accountList.add(new CheckingAccount(accountNr));
	}

	public List<BankAccount> getAccountList() {
		return accountList;
	}

	public int getClientNr() {
		return clientNr;
	}

	public void setClientNr(int clientNr) {
		this.clientNr = clientNr;
	}

	// Method that add accounts to accountlist
	public void addAccount(BankAccount account) {
		accountList.add(account);
	}

	@Override
	public String toString() {
		return "----------------------------\n" + "Name: " + getFirstName() + " " + getLastName() + "\nClientNumber: "
				+ clientNr + "\n----------------------------\n";
	}

}
