package com.ya.mybank.service;

import com.ya.mybank.bank.Bank;
import com.ya.mybank.bank.BankConsoleOutput;
import com.ya.mybank.person.Client;
import com.ya.mybank.util.InputScanner;

import com.ya.mybank.util.ConsoleOutput;
import com.ya.mybank.util.InputSafetyChecker;

public class MoneyTransfer {

	private String accountNr;
	private double sum;
	private int index = 0;
	private boolean doExist = false, correctFormat = false;

	public void depositToChosenAccount(Bank bank, BankConsoleOutput output) {

		output.printClientList(bank);
		System.out.println("\n------ DEPOSIT ------");
		System.out.println("Please enter accountnumber for the account you wish to deposit to.");
		do {
			System.out.print("Accountnumber: ");
			accountNr = InputScanner.scan.nextLine();
			correctFormat = InputSafetyChecker.isCorrectAccountNr(accountNr);
			if (correctFormat) {
				doExist = InputSafetyChecker.doExistAccountNr(bank, accountNr);
			}
		} while (!correctFormat || !doExist);

		System.out.println("How much do you wish to deposit? ");
		do {
			System.out.print("Enter amount ($): ");
			sum = InputScanner.scan.nextDouble();
			correctFormat = InputSafetyChecker.isCorrectDepositSum(sum);
		} while (!correctFormat);
		index = findIndexOfAccountOwner(bank, accountNr);
		bank.getClientList().get(index).getAccount().deposit(sum);
		System.out.println("\nDone. " + sum + " $ deposited to accountnumber: " + accountNr);

	}

	public void withdrawFromChosenAccount(Bank bank, BankConsoleOutput output) {

		output.printClientList(bank);
		System.out.println("\n------ WITHDRAW ------");
		System.out.println("Please enter accountnumber for the account you wish to deposit to.");
		do {
			System.out.print("Accountnumber: ");
			accountNr = InputScanner.scan.nextLine();
			correctFormat = InputSafetyChecker.isCorrectAccountNr(accountNr);
			if (correctFormat) {
				doExist = InputSafetyChecker.doExistAccountNr(bank, accountNr);
			}
		} while (!correctFormat || !doExist);

		System.out.println("How much do you wish to withdraw? ");
		do {
			System.out.print("Enter amount ($): ");
			sum = InputScanner.scan.nextDouble();
			correctFormat = InputSafetyChecker.isCorrectWithdrawSum(sum);
		} while (!correctFormat);
		index = findIndexOfAccountOwner(bank, accountNr);
		bank.getClientList().get(index).getAccount().withdraw(sum);
		System.out.println("\nDone. " + sum + " $ withdrawed from accountnumber: " + accountNr);
	}

	// Searching for the ownerindex of a accountNr and returning it
	private int findIndexOfAccountOwner(Bank bank, String accountNr) {
		int ownerIndex = -1;
		int i = 0;
		for (Client client : bank.getClientList()) {
			if (accountNr.equals(client.getAccount().getAccountNr())) {
				return ownerIndex = i;
			} else {
				i++;
			}
		}
		return ownerIndex;
	}
}
