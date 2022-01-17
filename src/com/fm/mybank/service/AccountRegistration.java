package com.fm.mybank.service;

import com.fm.mybank.bank.BankController;
import com.fm.mybank.person.Client;
import com.fm.mybank.util.ConsolePrinter;
import com.fm.mybank.util.InputSafetyChecker;

/*
 * Class with methods for logic & input related to account registration
 */
public class AccountRegistration {

	// Method that takes input from user & add new account to client
	public void regAccount(BankController bankController) {
		
		String accountNr;
		int chosenName, chosenAccountType;
		Client chosenClient;
		boolean correctInfo = false;
		
		do {
			
		System.out.println("--- ACCOUNT REGISTRATION ---");
		System.out.println("Please enter all necassary information below.\n");
		System.out.print("Which client do you want to create a new account for?");
		bankController.PrintClientNameList();
		System.out.print("Choice: ");
		chosenName = InputSafetyChecker.readInt();
		chosenClient = bankController.getBankClientList().get(chosenName-1);
		ConsolePrinter.thankYouPleaseWait();
		
		System.out.println("\nWhich type of account do you want to create?");
		do {
			System.out.println("1. Checking account\n2. Savings account");
			chosenAccountType = InputSafetyChecker.readInt();
			ConsolePrinter.thankYouPleaseWait();
			if (chosenAccountType != 1 && chosenAccountType != 2) {
				System.out.println("Invalid input");
			}
		} while (chosenAccountType == 1 && chosenAccountType == 2);
		
		System.out.println("\nEnter accountnumber in this format (123456-7). ");
		System.out.print("Accountnumber: ");
		accountNr = InputSafetyChecker.readCorrectAccountNr();
		
		if(chosenAccountType == 1) {
			bankController.addCheckingAccountToClient(chosenClient, accountNr);
			System.out.println("Done. Account created.\n");
			System.out.println("Type: Checking Account" + "\nAccountnr: " + accountNr);
		}
		else if (chosenAccountType == 2) {
			bankController.addSavingsAccountToClient(chosenClient, accountNr);
			System.out.println("Done. Account created.\n");
			System.out.println("Type: Checking Account" + "\nAccountnr: " + accountNr);
		}
		
		correctInfo = InputSafetyChecker.isThisInfoCorrect();
		
		} while (!correctInfo);
	}
}
