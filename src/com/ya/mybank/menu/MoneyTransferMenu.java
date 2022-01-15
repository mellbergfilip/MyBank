package com.ya.mybank.menu;

import com.ya.mybank.bank.Bank;
import com.ya.mybank.bank.BankConsoleOutput;
import com.ya.mybank.service.MoneyTransfer;
import com.ya.mybank.util.ConsoleOutput;
import com.ya.mybank.util.InputSafetyChecker;
import com.ya.mybank.util.InputScanner;

public class MoneyTransferMenu {

	// neccessary objects
	private MoneyTransfer moneyTransfer = new MoneyTransfer();

	// logic for moneytransfer menu
	public void runMoneyTransferMenu(Bank bank, BankConsoleOutput bankPrinter) {

		int menuChoice = 0;

		while (menuChoice != 3) {
			printMenu2();
			menuChoice = InputSafetyChecker.readInt();
			ConsoleOutput.dottedLine();
			switch (menuChoice) {
			case 1:
				moneyTransfer.depositToChosenAccount(bank, bankPrinter);
				break;
			case 2:
				moneyTransfer.withdrawFromChosenAccount(bank, bankPrinter);
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}

	// moneytransfer menu printout
	private void printMenu2() {
		System.out.println("------ TRANSFER MONEY ------");
		System.out.println("1. Deposit money ");
		System.out.println("2. Withdraw money");
		System.out.println("3. Go back to startmenu");
		System.out.print("Choice: ");
	}
}
