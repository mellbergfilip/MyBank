package com.ya.mybank.menu;

import com.ya.mybank.bank.Bank;
import com.ya.mybank.bank.BankConsoleOutput;

import com.ya.mybank.service.ClientRegistration;
import com.ya.mybank.util.ConsoleOutput;
import com.ya.mybank.util.InputScanner;

public class StartMenu {

	// neccessary objects
	private ClientRegistration clientReg = new ClientRegistration();
	private MoneyTransferMenu transferMenu = new MoneyTransferMenu();

	// logic for startmenu
	public void runStartMenu(Bank bank, BankConsoleOutput bankPrinter) {
		int menuChoice = 0;

		while (menuChoice != 4) {

			printStartMenu();
			menuChoice = InputScanner.scan.nextInt();
			InputScanner.scan.nextLine(); // consume scanner
			ConsoleOutput.dottedLine();
			switch (menuChoice) {
			case 1:
				clientReg.regCustomer(bank);
				break;
			case 2:
				bankPrinter.printClientList(bank);
				break;
			case 3:
				transferMenu.runMoneyTransferMenu(bank, bankPrinter);
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

	// startmenu printout
	private void printStartMenu() {
		System.out.println("------ STARTMENU ------");
		System.out.println("1. Register client ");
		System.out.println("2. View clients");
		System.out.println("3. Transfer money");
		System.out.println("4. Exit application");
		System.out.print("Choice: ");
	}

}
