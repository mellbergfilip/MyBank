package com.ya.mybank.account;

/*
 * Class that holds data for CheckingAccount objects
 * Subclass to BankAccount
 * Extends all methods & variables from BankAccount
 * At the moment nothing matters from SavingsAccount
 * This was just to learn object-oriented thinking
 */
public class CheckingAccount extends BankAccount {

	// Constructor that wants accountNr as parameter
	public CheckingAccount(String accountNr) {
		super();
		setAccountNr(accountNr);
	}

	@Override
	public String toString() {
		return "\nType: Checking account" + "\nAccountnr: " + accountNr + "\nBalance: " + balance + " $\n";
	}

}
