package com.ya.mybank.account;

/*
 * Abstract class that holds data for bankAccount objects
 * Baseclass to CheckingAccount and SavingsAccount
 * Withdraw/Deposit methods to manipulate balance
 */
public abstract class BankAccount {

	protected String accountNr;
	protected double balance;

	public String getAccountNr() {
		return accountNr;
	}

	// Setmethod that checks if accountNr is correct length (8)
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

	/*
	 * Method that takes double as parameter, controls if double is >= 0, adding
	 * double to balance
	 */
	public void deposit(double sum) {
		if (sum >= 0) {
			balance = balance + sum;
		} else {
			throw new IllegalArgumentException("You can't deposit a negative sum.");
		}
	}

	/*
	 * Method that takes a double as parameter, controls if double is <= balance and
	 * double is >= 0, taking double from balance
	 */
	public void withdraw(double sum) {
		if (sum <= balance && sum >= 0) {
			balance = balance - sum;
		} else {
			throw new IllegalArgumentException("You can't withdraw a negative sum.");
		}
	}
}
