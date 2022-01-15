package com.ya.mybank.account;

public class CheckingAccount extends BankAccount{


	public CheckingAccount(String accountNr) {
		super();
		setAccountNr(accountNr);
	}

	@Override
	public String toString() {
		return "\nType: Checking account" + "\nAccountnr: " + accountNr + "\nBalance: " + balance + " $\n";
	}

}
