package com.ya.mybank.application;

import com.ya.mybank.bank.Bank;
import com.ya.mybank.bank.BankController;
import com.ya.mybank.bank.BankView;
import com.ya.mybank.menu.StartMenu;
import com.ya.mybank.person.Client;

/*
 * Class that objects the application,
 * and runs the overall logic
 */
public class Application {

	// Create bank object and start menu object
//	private Bank bank = new Bank("Banken", "Sundsvall");
	private StartMenu menu = new StartMenu();
	
	//test
	private Bank bank = new Bank("Banken", "Sundsvall");
	private BankView bankView = new BankView();
	private BankController bankController = new BankController(bank, bankView);

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
