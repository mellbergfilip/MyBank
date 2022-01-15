package com.ya.mybank.menu;

import com.ya.mybank.bank.Bank;
import com.ya.mybank.bank.BankConsoleOutput;
import com.ya.mybank.util.ConsoleOutput;
import com.ya.mybank.util.InputSafetyChecker;

/*
 * Class that contains logic and print
 * for start menu
 */
public class StartMenu {

	// Create MoneyTransferMenu & RegistrationMenu
	private MoneyTransferMenu transferMenu = new MoneyTransferMenu();
	private RegistrationMenu regMenu = new RegistrationMenu();

	/* Logic for start menu
	 * Switch/Case Menu
	 */
	public void runStartMenu(Bank bank) {
		int menuChoice = 0;

		while (menuChoice != 4) {

			printStartMenu();
			menuChoice = InputSafetyChecker.readInt();
			ConsoleOutput.dottedLine();
			switch (menuChoice) {
			case 1:
				BankConsoleOutput.printClientInfoList2(bank);
				break;
			case 2:
				regMenu.runRegMenu(bank);
				break;
			case 3:
				transferMenu.runMoneyTransferMenu(bank);
				break;
			case 4:
				ConsoleOutput.shuttingDown();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}


	// Method that prints out start menu to console
	private void printStartMenu() {
		System.out.println("------ START ---------------");
		System.out.println("1. View clients ");
		System.out.println("2. Registration");
		System.out.println("3. Transfer money");
		System.out.println("4. Exit application");
		System.out.print("Choice: ");
	}

}
