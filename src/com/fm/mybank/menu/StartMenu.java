package com.fm.mybank.menu;

import com.fm.mybank.bank.BankController;
import com.fm.mybank.util.ConsolePrinter;
import com.fm.mybank.util.InputSafetyChecker;

/*
 * Class that contains methods for logic and console print
 * in start menu
 */
public class StartMenu {

	// Create MoneyTransferMenu & RegistrationMenu
	private MoneyTransferMenu transferMenu = new MoneyTransferMenu();
	private RegistrationMenu regMenu = new RegistrationMenu();

	/* Logic for start menu
	 * Switch/Case Menu
	 */
	public void runStartMenu(BankController bankController) {
		int menuChoice = 0;

		while (menuChoice != 4) {

			printStartMenu();
			menuChoice = InputSafetyChecker.readInt();
			ConsolePrinter.dottedLine();
			switch (menuChoice) {
			case 1:
				bankController.PrintClientInfoList();
				break;
			case 2:
				regMenu.runRegMenu(bankController);
				break;
			case 3:
				transferMenu.runMoneyTransferMenu(bankController);
				break;
			case 4:
				ConsolePrinter.shuttingDown();
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
