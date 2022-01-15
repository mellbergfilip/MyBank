package com.ya.mybank.bank;

import com.ya.mybank.account.BankAccount;
import com.ya.mybank.person.Client;

public class BankConsoleOutput {

	// printout all clients info in a list (trough toString())
	public void printClientInfoList(Bank bank) {
		System.out.println("------ CLIENTLIST ----------");
		for (Client client : bank.getClientList()) {
			System.out.println(client);
		}
	}

	public void printClientInfoList2(Bank bank) {
		System.out.println("------ CLIENTLIST ----------");
		for (Client client : bank.getClientList()) {
			System.out.println(
					"----------------------------\n" + "Name: " + client.getFirstName() + " " + client.getLastName()
							+ "\nClientNumber: " + client.getClientNr());
			for ( BankAccount account : client.getAccountList()) {
				System.out.println("\n* Type: " + account.getClass().getSimpleName() + "\nAccountnr: " + account.getAccountNr() + "\nBalance: " + account.getBalance() + " $");
			}
			System.out.println("\n----------------------------\n");
		}
	}

	// printout all clients name in a list
	public void printClientNameList(Bank bank) {
		int i = 1;
		System.out.println("\n------ CLIENTLIST ----------");
		for (Client client : bank.getClientList()) {
			System.out.println(i + ". " + client.getFirstName() + " " + client.getLastName());
			i++;
		}
	}

}
