package com.fm.mybank.account;

/*
 * Model class that represent savings account
 * Subclass to BankAccount
 * Extends all methods & variables from BankAccount
 * Right now there is no difference from BankAccount
 * This was just to learn more about object-oriented
 * programming and Java
 */
public class SavingsAccount extends BankAccount {

	// Constructor that wants accountNr as parameter
	public SavingsAccount(String accountNr) {
		super();
		setAccountNr(accountNr);
	}

	@Override
	public String toString() {
		return "\nType: Savings account" + "\nAccountnr: " + accountNr + "\nBalance: " + balance + " $\n";
	}
}
