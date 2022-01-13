package com.ya.mybank.account;

public class BankAccount {

	private String accountNr;
	private double balance;

	public BankAccount() {
		super();
	}

	// Constructor used for premaking clients
	public BankAccount(String accountNr) {
		super();
		setAccountNr(accountNr);
	}

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

	@Override
	public String toString() {
		return "BankAccount: " + accountNr + "\t|\tBalance: " + balance + " $";
	}

}
