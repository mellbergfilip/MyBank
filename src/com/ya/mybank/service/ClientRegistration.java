package com.ya.mybank.service;

import com.ya.mybank.bank.Bank;
import com.ya.mybank.person.Client;
import com.ya.mybank.util.InputScanner;
import com.ya.mybank.util.ConsoleOutput;
import com.ya.mybank.util.InputSafetyChecker;

public class ClientRegistration {

	public void regCustomer(Bank bank) {
		
		String firstName, lastName, accountNr;
		Client currentClient;
		boolean correctFormat = false, correctInfo = false;
		do {
			
		System.out.println("------ REGISTRATION ------");
		System.out.println("Please enter all necassary information below.\n");
		System.out.print("Firstname: ");
		firstName = InputScanner.scan.nextLine();
		System.out.print("Lastname: ");
		lastName = InputScanner.scan.nextLine();
		ConsoleOutput.thankYouPleaseWait();
		currentClient = new Client(firstName,lastName);
		System.out.println("Client created.");
		System.out.println("\nFor now you can only create one account for this client.");
		System.out.println("Enter accountnumber in this format (123456-7). ");
		do {
			System.out.print("Accountnumber: ");
			accountNr = InputScanner.scan.nextLine();
			correctFormat = InputSafetyChecker.isCorrectAccountNr(accountNr);
		} while (!correctFormat);
		currentClient.getAccount().setAccountNr(accountNr);
		System.out.println("\nDone. Account created.\n");
		currentClient.setClientNr(bank.getClientList().size()+1); // Sets clientNumber to (amount of clients + 1)
		bank.addClient(currentClient);
		System.out.println(currentClient);
		correctInfo = isThisInfoCorrect();
		
		} while (!correctInfo);
	}
	
	private boolean isThisInfoCorrect() {
		boolean isCorrectInfo = false;
		System.out.println("Is this information correct?");
		System.out.print("(y/n): ");
		String yesOrNo = InputScanner.scan.nextLine();
		System.out.println();
		if (yesOrNo.toLowerCase().equals("y")) {
			return isCorrectInfo = true;
		}
		else if (yesOrNo.toLowerCase().equals("n")) {
			System.out.println("Please follow all the steps again.\n");
			return isCorrectInfo;
		}
		else {
			return isCorrectInfo;
		}
	}

}
