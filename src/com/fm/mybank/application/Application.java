package com.fm.mybank.application;

import com.fm.mybank.bank.Bank;
import com.fm.mybank.bank.BankController;
import com.fm.mybank.bank.BankView;
import com.fm.mybank.menu.StartMenu;
import com.fm.mybank.person.Client;

/*
 * Class that represents the whole application,
 * and runs the overall logic
 */
public class Application {

	// Create bank, controller and start menu
	private Bank bank = new Bank("Banken", "Sundsvall");
	private BankView bankView = new BankView();
	private BankController bankController = new BankController(bank, bankView);
	private StartMenu menu = new StartMenu();
	
	// Overall application logic
	public void runApp() {

		// Add a few clients with accounts
		Client tony = new Client("Tony", "Stark", "123456-7");
		Client diana = new Client("Diana", "Prince", "333555-7");
		Client steve = new Client("Steve", "Rogers", "999444-3");
		Client natasha = new Client("Natasha", "Romanova", "111111-3");
		bankController.addClient(tony);
		bankController.addClient(diana);
		bankController.addClient(steve);
		bankController.addClient(natasha);
		bankController.depositToAccount("123456-7", 50000000);
		bankController.depositToAccount("111111-3", 1000);
		
		bankController.PrintWelcomeMessage();
		menu.runStartMenu(bankController);
	}
}
