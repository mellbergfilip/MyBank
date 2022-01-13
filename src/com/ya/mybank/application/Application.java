package com.ya.mybank.application;

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

	// Application logic
	public void runApp() {
		// Lägger till några klienter samt konton
		Client anna = new Client("Kajsa", "Anka", 1, "123456-7");
		Client pelle = new Client("Pelle", "Svanslös", 2, "333555-7");
		bank.addClient(anna);
		bank.addClient(pelle);

		ConsoleOutput.welcomeMessage(bank);
		menu.runStartMenu(bank, bankPrinter);

	}
}
