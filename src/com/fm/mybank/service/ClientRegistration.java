package com.fm.mybank.service;

import com.fm.mybank.bank.BankController;
import com.fm.mybank.person.Client;
import com.fm.mybank.util.ConsolePrinter;
import com.fm.mybank.util.InputSafetyChecker;
import com.fm.mybank.util.InputScanner;

/*
 * Class with methods for logic & input related to client registration
 */
public class ClientRegistration {

	// Method that takes input from user & add new client to bank
	public void regCustomer(BankController bankController) {

		String firstName, lastName;
		Client newClient;
		boolean correctInfo = false;
		
		do {
			
			System.out.println("--- CLIENT REGISTRATION ----");
			System.out.println("Please enter all necassary information below.\n");
			System.out.print("Firstname: ");
			firstName = InputScanner.scan.nextLine();
			System.out.print("Lastname: ");
			lastName = InputScanner.scan.nextLine();
			ConsolePrinter.thankYouPleaseWait();
			newClient = new Client(firstName, lastName);
			System.out.println("Client created.");
			bankController.addClient(newClient);
			bankController.printClientInfo(newClient);
			correctInfo = InputSafetyChecker.isThisInfoCorrect();
			
		} while (!correctInfo);
	}

}
