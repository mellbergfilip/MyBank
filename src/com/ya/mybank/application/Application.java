package com.ya.mybank.application;

import com.ya.mybank.account.SavingsAccount;
import com.ya.mybank.bank.Bank;
import com.ya.mybank.menu.StartMenu;
import com.ya.mybank.person.Client;
import com.ya.mybank.util.ConsoleOutput;

/*
 * Class that objects the application,
 * and runs the overall logic
 */
public class Application {

	// Create bank object and start menu object
	private Bank bank = new Bank("Banken", "Sundsvall");
	private StartMenu menu = new StartMenu();

	// Overall application logic
	public void runApp() {

		// Add a few clients with accounts
		Client tony = new Client("Tony", "Stark", 1, "123456-7");
		Client diana = new Client("Diana", "Prince", 2, "333555-7");
		Client steve = new Client("Steve", "Rogers", 3, "999444-3");
		Client natasha = new Client("Natasha", "Romanova", 4, "111111-3");
		tony.addAccount(new SavingsAccount("666666-1"));
		tony.getAccountList().get(0).deposit(500000);
		diana.addAccount(new SavingsAccount("123999-4"));
		diana.getAccountList().get(0).deposit(10000);
		bank.addClient(tony);
		bank.addClient(diana);
		bank.addClient(steve);
		bank.addClient(natasha);

		ConsoleOutput.welcomeMessage(bank);
		menu.runStartMenu(bank);
	}
}
