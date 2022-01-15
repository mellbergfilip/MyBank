package com.ya.mybank.service;

import com.ya.mybank.bank.Bank;
import com.ya.mybank.person.Client;
import com.ya.mybank.util.InputScanner;
import com.ya.mybank.util.ConsoleOutput;
import com.ya.mybank.util.InputSafetyChecker;

/*
 * Class that contains logic & input for client registration
 */
public class ClientRegistration {

	// Method that takes input from user & add new client to bank
	public void regCustomer(Bank bank) {

		String firstName, lastName;
		Client currentClient;
		boolean correctInfo = false;
		
		do {
			
			System.out.println("--- CLIENT REGISTRATION ----");
			System.out.println("Please enter all necassary information below.\n");
			System.out.print("Firstname: ");
			firstName = InputScanner.scan.nextLine();
			System.out.print("Lastname: ");
			lastName = InputScanner.scan.nextLine();
			ConsoleOutput.thankYouPleaseWait();
			currentClient = new Client(firstName, lastName);
			System.out.println("Client created.");
			currentClient.setClientNr(bank.getClientList().size() + 1); // Sets clientNumber to (amount of clients + 1)
			bank.addClient(currentClient);
			System.out.println(currentClient);
			correctInfo = InputSafetyChecker.isThisInfoCorrect();
			
		} while (!correctInfo);
	}

}
