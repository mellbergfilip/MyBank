package com.fm.mybank.service;

import java.util.List;

import com.fm.mybank.account.BankAccount;
import com.fm.mybank.bank.BankController;
import com.fm.mybank.person.Client;
import com.fm.mybank.util.InputSafetyChecker;

/*
 * Class with methods for logic & input related to money transfer
 */
public class MoneyTransfer {

	// Common shared variables for all methods in class
	private BankAccount chosenAccount;
	private String accountNr;
	private double sum;

	// Method that takes input from user & deposit chosen sum to chosen account
	public void depositToChosenAccount(BankController bankController) {

		bankController.PrintClientInfoList();
		System.out.println("-------- DEPOSIT -----------");
		System.out.println("Please enter accountnumber for the account you wish to deposit to.");
		do {
			System.out.print("Accountnumber: ");
			accountNr = InputSafetyChecker.readCorrectAccountNr();
			chosenAccount = findChosenAccount(bankController.getBankClientList(), accountNr);
			;
		} while (chosenAccount == null);

		System.out.println("\nHow much do you wish to deposit? ");
		System.out.print("Enter amount ($): ");
		sum = InputSafetyChecker.readCorrectDepositSum();
		bankController.depositToAccount(accountNr, sum);
		System.out.println("\nDone. " + sum + " $ deposited to accountnumber: " + accountNr + "\n");

	}

	// Method that takes input from user & withdraw chosen sum from chosen account
	public void withdrawFromChosenAccount(BankController bankController) {

		bankController.PrintClientInfoList();
		;
		System.out.println("--------- WITHDRAW ---------");
		System.out.println("Please enter accountnumber for the account you wish to withdraw from.");
		do {
			System.out.print("Accountnumber: ");
			accountNr = InputSafetyChecker.readCorrectAccountNr();
			chosenAccount = findChosenAccount(bankController.getBankClientList(), accountNr);
			;
		} while (chosenAccount == null);

		double currentBalance = chosenAccount.getBalance();

		System.out.println("\nHow much do you wish to withdraw? ");
		System.out.print("Enter amount ($): ");
		sum = InputSafetyChecker.readCorrectWithdrawSum();

		while (!checkIfEnoughMoney(sum, currentBalance)) {
			System.out.println("\nIt is not enough money on the account. Please try again:");
			System.out.print("Enter amount ($): ");
			sum = InputSafetyChecker.readCorrectWithdrawSum();
		}

		bankController.withdrawFromAccount(accountNr, sum);
		System.out.println("\nDone. " + sum + " $ withdrawed from accountnumber: " + accountNr + "\n");
	}

	// Method that search for bankAccount in a list of clients and return it
	private BankAccount findChosenAccount(List<Client> clientList, String accountNr) {
		BankAccount chosenAccount;

		for (Client client : clientList) {
			for (int j = 0; j < client.getAccountList().size(); j++) {
				if (accountNr.equals(client.getAccountList().get(j).getAccountNr())) {
					chosenAccount = client.getAccountList().get(j);
					return chosenAccount;
				}
			}
		}
		System.out.println("\nCouldn't find accountnumber.");
		return null;
	}

	/*
	 * Method that checks if there is enough money on balance Takes chosen sum and
	 * current balance as parameters
	 */
	private boolean checkIfEnoughMoney(double sum, double balance) {
		if (sum <= balance) {
			return true;
		} else {
			return false;
		}
	}
}
