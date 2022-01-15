package com.ya.mybank.application;

import com.ya.mybank.account.CheckingAccount;
import com.ya.mybank.account.SavingsAccount;
import com.ya.mybank.bank.Bank;
import com.ya.mybank.bank.BankConsoleOutput;
import com.ya.mybank.menu.StartMenu;
import com.ya.mybank.person.Client;
import com.ya.mybank.util.ConsoleOutput;

public class Application {

	// neccessary objects
	private Bank bank = new Bank("Banken", "Sundsvall");
	private BankConsoleOutput bankPrinter = new BankConsoleOutput();
	private StartMenu menu = new StartMenu();

	// application logic
	public void runApp() {
		
		// add a few clients with accounts
		Client anna = new Client("Kajsa", "Anka", 1, "123456-7");
		Client pelle = new Client("Pelle", "Svanslös", 2, "333555-7");
		pelle.addAccount(new SavingsAccount("666666-1"));
		bank.addClient(anna);
		bank.addClient(pelle);

		ConsoleOutput.welcomeMessage(bank);
		menu.runStartMenu(bank, bankPrinter);

	}
}
