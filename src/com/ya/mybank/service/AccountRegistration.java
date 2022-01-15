package com.ya.mybank.service;

import com.ya.mybank.account.BankAccount;
import com.ya.mybank.account.CheckingAccount;
import com.ya.mybank.account.SavingsAccount;
import com.ya.mybank.bank.Bank;
import com.ya.mybank.bank.BankConsoleOutput;
import com.ya.mybank.util.ConsoleOutput;
import com.ya.mybank.util.InputSafetyChecker;
import com.ya.mybank.util.InputScanner;

public class AccountRegistration {

	public void regAccount(Bank bank, BankConsoleOutput bankPrinter) {
		
		String accountNr;
		int chosenName, chosenAccountType;
		BankAccount newAccount;
		boolean correctFormat = false, correctInfo = false;
		
		do {
			
		System.out.println("--- ACCOUNT REGISTRATION ---");
		System.out.println("Please enter all necassary information below.\n");
		System.out.print("Which client do you want to create a new account for?");
		bankPrinter.printClientNameList(bank);
		System.out.println("Choice: ");
		chosenName = InputSafetyChecker.readInt();
		ConsoleOutput.thankYouPleaseWait();
		
		System.out.println("\nWhich type of account do you want to create?");
		do {
			System.out.println("1. Checking account\n2. Savings account");
			chosenAccountType = InputSafetyChecker.readInt();
			ConsoleOutput.thankYouPleaseWait();
			if (chosenAccountType != 1 && chosenAccountType != 2) {
				System.out.println("Invalid input");
			}
		} while (chosenAccountType == 1 && chosenAccountType == 2);
		
		do {
			System.out.println("\nEnter accountnumber in this format (123456-7). ");
			System.out.print("Accountnumber: ");
			accountNr = InputScanner.scan.nextLine();
			correctFormat = InputSafetyChecker.isCorrectAccountNr(accountNr);
		} while (!correctFormat);
		
		if(chosenAccountType == 1) {
			newAccount = new CheckingAccount(accountNr);
			bank.getClientList().get(chosenName-1).addAccount(newAccount);
			System.out.println("Done. Account created.\n");
			System.out.println(newAccount);
		}
		else if (chosenAccountType == 2) {
			newAccount = new SavingsAccount(accountNr);
			bank.getClientList().get(chosenName-1).addAccount(newAccount);
			System.out.println("Done. Account created.\n");
			System.out.println(newAccount);
		}
		
		correctInfo = InputSafetyChecker.isThisInfoCorrect();
		
		} while (!correctInfo);
	}
}