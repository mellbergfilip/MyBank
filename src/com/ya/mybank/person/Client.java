package com.ya.mybank.person;

import java.util.ArrayList;
import java.util.List;

import com.ya.mybank.account.BankAccount;
import com.ya.mybank.account.CheckingAccount;

public class Client extends Person {

	private List<BankAccount> accountList = new ArrayList<BankAccount>();
//	private CheckingAccount account;
	private int clientNr;

	public Client(String firstName, String lastName) {
		super(firstName, lastName);
	}

	// Constructor used for premaking clients
	public Client(String firstName, String lastName, int clientNr, String AccountNr) {
		super(firstName, lastName);
		this.clientNr = clientNr;
		accountList.add(new CheckingAccount(AccountNr));
	}

	public List<BankAccount> getAccountList() {
		return accountList;
	}

//	public CheckingAccount getAccount() {
//		return account;
//	}

	public int getClientNr() {
		return clientNr;
	}

	public void setClientNr(int clientNr) {
		this.clientNr = clientNr;
	}

	public void addAccount(BankAccount account) {
		accountList.add(account);
	}

	@Override
	public String toString() {
		return "----------------------------\n" + "Name: " + getFirstName() + " " + getLastName() + "\nClientNumber: "
				+ clientNr + "\n----------------------------\n";
	}

}
