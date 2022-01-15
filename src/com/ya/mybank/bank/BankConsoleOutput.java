package com.ya.mybank.bank;

import com.ya.mybank.account.BankAccount;
import com.ya.mybank.person.Client;

/*
 * Class with static methods,
 * that prints out various bankinformation
 * to console
 */
public class BankConsoleOutput {

	// Private constructor so object can't be created
	private BankConsoleOutput() {
		super();
	}

	// Method that prints out clientlist, clientinfo (account, nr, name) to console
	public static void printClientInfoList2(Bank bank) {
		System.out.println("------ CLIENTLIST ----------");
		for (Client client : bank.getClientList()) {
			System.out.println("----------------------------\n" + "Name: " + client.getFirstName() + " "
					+ client.getLastName() + "\nClientNumber: " + client.getClientNr());
			for (BankAccount account : client.getAccountList()) {
				System.out.println("\n* Type: " + account.getClass().getSimpleName() + "\nAccountnr: "
						+ account.getAccountNr() + "\nBalance: " + account.getBalance() + " $");
			}
			System.out.println("\n----------------------------\n");
		}
	}

	// Method that prints out clientlist (only names) to console
	public static void printClientNameList(Bank bank) {
		int i = 1;
		System.out.println("\n------ CLIENTLIST ----------");
		for (Client client : bank.getClientList()) {
			System.out.println(i + ". " + client.getFirstName() + " " + client.getLastName());
			i++;
		}
	}

}
