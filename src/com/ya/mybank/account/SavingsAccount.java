package com.ya.mybank.account;

/*
 * Class that holds data for SavingsAccounts objects
 * Subclass to BankAccount
 * Extends all methods & variables from BankAccount
 * At the moment nothing matters from CheckingAccount
 * This was just to learn object-oriented thinking
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
