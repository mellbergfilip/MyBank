package com.fm.mybank.menu;

import com.fm.mybank.bank.BankController;
import com.fm.mybank.service.AccountRegistration;
import com.fm.mybank.service.ClientRegistration;
import com.fm.mybank.util.ConsolePrinter;
import com.fm.mybank.util.InputSafetyChecker;

/*
 * Class that contains methods for logic and console print
 * in registration menu
 */
public class RegistrationMenu {

	// Create services ClientRegistration & AccountRegistration
	private ClientRegistration clientReg = new ClientRegistration();
	private AccountRegistration accountReg = new AccountRegistration();

	/* Logic for Registration menu
	 * Switch/Case Menu
	 */
	public void runRegMenu(BankController bankController) {

		int menuChoice = 0;
		while (menuChoice != 3) {

			printRegMenu();
			menuChoice = InputSafetyChecker.readInt();
			ConsolePrinter.dottedLine();
			switch (menuChoice) {
			case 1:
				clientReg.regCustomer(bankController);
				break;
			case 2:
				accountReg.regAccount(bankController);
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
