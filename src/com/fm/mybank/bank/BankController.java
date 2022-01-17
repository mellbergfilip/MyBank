package com.fm.mybank.bank;

import java.util.List;

import com.fm.mybank.account.CheckingAccount;
import com.fm.mybank.account.SavingsAccount;
import com.fm.mybank.person.Client;

/*
 * Controller class for bank
 * Controls the flow of all data within bank,
 * and also the BankView class
 * Various methods like addClient(),
 * addAccountToClient(), deposit(), withdraw()
 * Also updates/runs all the printMethods in view class
 */
public class BankController {

	private Bank bank;
	private BankView view;

	public BankController(Bank bank, BankView view) {
		super();
		this.bank = bank;
		this.view = view;

	}

	/*
	 * Method used for premaking clients Adds client to bank clientlist Client as
	 * parameter
	 */
	public void addClient(Client newClient) {
		bank.getClientList().add(newClient);
		newClient.setClientNr(bank.getClientList().size());
	}
	
	/*
	 * Method that add checking account to client
	 * Takes client and accountNr as parameters
	 */
	public void addCheckingAccountToClient(Client client, String accountNr) {
		CheckingAccount newAccount = new CheckingAccount(accountNr);
		client.addAccount(newAccount);
	}
	
	/*
	 * Method that add savings account to client
	 * Takes client and accountNr as parameters
	 */
	public void addSavingsAccountToClient(Client client, String accountNr) {
		SavingsAccount newAccount = new SavingsAccount(accountNr);
		client.addAccount(newAccount);
	}

	/*
	 * Method that takes double and accountNR as parameter,
	 * search correct account first, 
	 * then controls if double is >= 0, adding
	 * double to balance
	 */
	public void depositToAccount(String accountNr, double sum) {

		for (Client client : bank.getClientList()) {
			for (int j = 0; j < client.getAccountList().size(); j++) {
				if (accountNr.equals(client.getAccountList().get(j).getAccountNr())) {
					client.getAccountList().get(j).deposit(sum);
				}
			}
		}
	}

	/*
	 * Method that takes double and accountNR as parameter,
	 * search correct account first, 
	 * then controls if double is >= 0, withdrawing
	 * double from balance
	 */
	public void withdrawFromAccount(String accountNr, double sum) {
		for (Client client : bank.getClientList()) {
			for (int j = 0; j < client.getAccountList().size(); j++) {
				if (accountNr.equals(client.getAccountList().get(j).getAccountNr())) {
					client.getAccountList().get(j).withdraw(sum);
				}
			}
		}
	}

	public String getBankName() {
		return bank.getName();
	}

	public String getBankCity() {
		return bank.getCity();
	}

	public List<Client> getBankClientList() {
		return bank.getClientList();
	}

	public void PrintClientInfoList() {
		view.printClientInfoList(bank.getClientList());
	}

	public void PrintClientNameList() {
		view.printClientNameList(bank.getClientList());
	}

	public void PrintWelcomeMessage() {
		view.printWelcomeMessage(bank.getName(), bank.getCity());
	}

	public void printClientInfo(Client client) {
		view.printClientInfo(client.getFirstName(), client.getLastName());
	}

}
