package com.ya.mybank.account;

public class SavingsAccount extends BankAccount {

	private final double savingsRate = 1.025; // 2.5 %
	
	public SavingsAccount(String accountNr) {
		super();
		setAccountNr(accountNr);
	}
	
	@Override
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
		return "\nType: Savings account" + "\nAccountnr: " + accountNr + "\nBalance: " + balance + " $\n";
	}
}
