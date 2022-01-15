package com.ya.mybank.account;

public abstract class BankAccount {

	protected String accountNr;
	protected double balance;


	public String getAccountNr() {
		return accountNr;
	}

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

	public void deposit(double sum) {
		if (sum > 0) {
			balance = balance + sum;
		} else {
			throw new IllegalArgumentException("You can't deposit a negative sum.");
		}
	}

	public void withdraw(double sum) {
		if (sum <= balance) {
			if (sum >= 0) {
				balance = balance - sum;
			}
		}
		else {
			throw new IllegalArgumentException("You can't withdraw a negative sum.");
		}
	}
}
