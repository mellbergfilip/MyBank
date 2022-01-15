package com.ya.mybank.service;

import com.ya.mybank.account.BankAccount;
import com.ya.mybank.bank.Bank;
import com.ya.mybank.bank.BankConsoleOutput;
import com.ya.mybank.person.Client;
import com.ya.mybank.util.InputSafetyChecker;

/*
 * Class that contains logic & input for money transfer
 */
public class MoneyTransfer {

	// Common shared variables for all methods in class
	private BankAccount chosenAccount;
	private String accountNr;
	private double sum;
	private boolean doExist = false;

	// Method that takes input from user & deposit chosen sum to chosen account
	public void depositToChosenAccount(Bank bank) {

		BankConsoleOutput.printClientInfoList2(bank);
		System.out.println("-------- DEPOSIT -----------");
		System.out.println("Please enter accountnumber for the account you wish to deposit to.");
		do {
			System.out.print("Accountnumber: ");
			accountNr = InputSafetyChecker.readCorrectAccountNr();
			doExist = InputSafetyChecker.doExistAccountNr(bank, accountNr);
		} while (!doExist);
		chosenAccount = findChosenAccount(bank, accountNr);
		
		System.out.println("\nHow much do you wish to deposit? ");
		System.out.print("Enter amount ($): ");
		sum = InputSafetyChecker.readCorrectDepositSum();
		chosenAccount.deposit(sum);
		System.out.println("\nDone. " + sum + " $ deposited to accountnumber: " + accountNr + "\n");

	}

	// Method that takes input from user & withdraw chosen sum from chosen account
	public void withdrawFromChosenAccount(Bank bank) {

		BankConsoleOutput.printClientInfoList2(bank);
		System.out.println("--------- WITHDRAW ---------");
		System.out.println("Please enter accountnumber for the account you wish to withdraw from.");
		do {
			System.out.print("Accountnumber: ");
			accountNr = InputSafetyChecker.readCorrectAccountNr();
			doExist = InputSafetyChecker.doExistAccountNr(bank, accountNr);
		} while (!doExist);
		chosenAccount = findChosenAccount(bank, accountNr);
		double currentBalance = chosenAccount.getBalance();
		System.out.println("\nHow much do you wish to withdraw? ");
		System.out.print("Enter amount ($): ");
		//reads chosen sum and checks if ok. Takes currentBalance as argument to check if withdrawal is okay
		sum = InputSafetyChecker.readCorrectWithdrawSum(currentBalance); 
		chosenAccount.withdraw(sum);
		System.out.println("\nDone. " + sum + " $ withdrawed from accountnumber: " + accountNr + "\n");
	}

	// Method that search for chosen bankAccount and return it
	private BankAccount findChosenAccount(Bank bank, String accountNr) {
		BankAccount chosenAccount;

		for (Client client : bank.getClientList()) {
			for (int j = 0; j < client.getAccountList().size(); j++) {
				if (accountNr.equals(client.getAccountList().get(j).getAccountNr())) {
					chosenAccount = client.getAccountList().get(j);
					return chosenAccount;
				}
			}
		}
		return bank.getClientList().get(0).getAccountList().get(0);
	}
}
