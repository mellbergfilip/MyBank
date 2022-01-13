package com.ya.mybank.util;

import com.ya.mybank.account.BankAccount;
import com.ya.mybank.bank.Bank;
import com.ya.mybank.person.Client;

public class InputSafetyChecker {

	public static boolean isCorrectAccountNr(String accountNr) {
		Client tempClient = new Client("Filip", "Mellberg");
		boolean correctFormat = false;
			try {
				tempClient.getAccount().setAccountNr(accountNr);
				ConsoleOutput.thankYouPleaseWait();
				return correctFormat = true;
			} catch (Exception e) {
				System.out.println("Wrong format for chosen accountnumber. Please try again.");
			}
			return correctFormat;
	}
	public static boolean isCorrectDepositSum(double sum) {
		BankAccount tempAccount = new BankAccount();
		boolean correctFormat = false;
			try {
				tempAccount.deposit(sum);
				ConsoleOutput.thankYouPleaseWait();
				return correctFormat = true;
			} catch (Exception e) {
				System.out.println("You can't deposit a negative sum.");
			}
			return correctFormat;
	}
	public static boolean isCorrectWithdrawSum(double sum) {
		BankAccount tempAccount = new BankAccount();
		boolean correctFormat = false;
			try {
				tempAccount.withdraw(sum);
				ConsoleOutput.thankYouPleaseWait();
				return correctFormat = true;
			} catch (Exception e) {
				System.out.println("You can't withdraw more than you have or a negative sum.");
			}
			return correctFormat;
	}
	
	public static boolean doExistAccountNr(Bank bank, String accountNr) {
		boolean doExist = false;
		for (Client client : bank.getClientList()) {
			if (accountNr.equals(client.getAccount().getAccountNr())) {
				return doExist = true;
			}
		}
		System.out.println("The number you have entered does not exist. Please try again:");
		return doExist;
	}
}
