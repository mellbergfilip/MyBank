package com.ya.mybank.menu;

import com.ya.mybank.bank.Bank;
import com.ya.mybank.service.AccountRegistration;
import com.ya.mybank.service.ClientRegistration;
import com.ya.mybank.util.ConsoleOutput;
import com.ya.mybank.util.InputSafetyChecker;

/*
 * Class that contains logic and print
 * for Registration menu
 */
public class RegistrationMenu {

	// Create services ClientRegistration & AccountRegistration
	private ClientRegistration clientReg = new ClientRegistration();
	private AccountRegistration accountReg = new AccountRegistration();

	/* Logic for Registration menu
	 * Switch/Case Menu
	 */
	public void runRegMenu(Bank bank) {

		int menuChoice = 0;
		while (menuChoice != 3) {

			printRegMenu();
			menuChoice = InputSafetyChecker.readInt();
			ConsoleOutput.dottedLine();
			switch (menuChoice) {
			case 1:
				clientReg.regCustomer(bank);
				break;
			case 2:
				accountReg.regAccount(bank);
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}

	// Method that prints out Registration menu to console
	private void printRegMenu() {
		System.out.println("------ REGISTRATION --------");
		System.out.println("1. Register new client ");
		System.out.println("2. Register new account");
		System.out.println("3. Go back to start");
		System.out.print("Choice: ");
	}
}
