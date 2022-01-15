package com.ya.mybank.service;

import com.ya.mybank.account.BankAccount;
import com.ya.mybank.bank.Bank;
import com.ya.mybank.bank.BankConsoleOutput;
import com.ya.mybank.person.Client;
import com.ya.mybank.util.InputScanner;
import com.ya.mybank.util.ConsoleOutput;
import com.ya.mybank.util.InputSafetyChecker;

public class MoneyTransfer {

	private BankAccount chosenAccount;
	private String accountNr;
	private double sum;
	private boolean doExist = false, correctFormat = false;

	public void depositToChosenAccount(Bank bank, BankConsoleOutput output) {

		output.printClientInfoList2(bank);
		System.out.println("-------- DEPOSIT -----------");
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
			sum = InputSafetyChecker.readDouble();
			correctFormat = InputSafetyChecker.isCorrectDepositSum(sum);
		} while (!correctFormat);
		chosenAccount = findChosenAccount(bank, accountNr);
		chosenAccount.deposit(sum);
		System.out.println("\nDone. " + sum + " $ deposited to accountnumber: " + accountNr + "\n");

	}

	public void withdrawFromChosenAccount(Bank bank, BankConsoleOutput output) {

		output.printClientInfoList2(bank);
		System.out.println("--------- WITHDRAW ---------");
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
			sum = InputSafetyChecker.readDouble();
			correctFormat = InputSafetyChecker.isCorrectWithdrawSum(sum);
		} while (!correctFormat);
		chosenAccount = findChosenAccount(bank, accountNr);
		chosenAccount.withdraw(sum);
		System.out.println("\nDone. " + sum + " $ withdrawed from accountnumber: " + accountNr + "\n");
	}

	// Searching for chosen bankAccount and return it
	private BankAccount findChosenAccount(Bank bank, String accountNr) {
		BankAccount chosenAccount;
		
		for (Client client : bank.getClientList()) {
			int i = 0;
			for (int j = 0; j < client.getAccountList().size(); j++) {
				if (accountNr.equals(client.getAccountList().get(j).getAccountNr())) {
					chosenAccount = client.getAccountList().get(j);
					return chosenAccount;
				}
				i++;
			}
		}
		return bank.getClientList().get(0).getAccountList().get(0);
	}
}
