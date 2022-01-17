package com.fm.mybank.account;

/*
 * Abstract model class that represents bank accounts
 * Baseclass to checking account and savings account
 * Withdraw/Deposit methods to manipulate balance
 * Right now there is very little data in this class
 * This was just to learn more about object-oriented
 * programming and Java
 */
public abstract class BankAccount {

	protected String accountNr;
	protected double balance;

	public String getAccountNr() {
		return accountNr;
	}

	// Setmethod that controls if accountNr is correct length (8)
	public void setAccountNr(String accountNr) {
		if (accountNr.length() == 8) {
			this.accountNr = accountNr;
		} else {
			throw new IllegalArgumentException("Wrong format for chosen accountnumber");
		}
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/*
	 * Method that takes double as parameter, controls if double is >= 0, 
	 * adding double to balance
	 */
	public void deposit(double sum) {
		if (sum >= 0) {
			balance = balance + sum;
		} else {
			throw new IllegalArgumentException("You can't deposit a negative sum.");
		}
	}

	/*
	 * Method that takes a double as parameter, controls if
	 * double is >= 0, taking double from balance
	 */
	public void withdraw(double sum) {
		if (sum >= 0) {
			balance = balance - sum;
		} else {
			throw new IllegalArgumentException("You can't withdraw a negative sum.");
		}
	}
}
