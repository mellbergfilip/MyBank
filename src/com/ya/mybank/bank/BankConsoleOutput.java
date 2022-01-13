package com.ya.mybank.bank;

import com.ya.mybank.person.Client;

public class BankConsoleOutput {

	public void printClientList(Bank bank) {
		System.out.println("\n------ CLIENTLIST ------");
		for(Client client : bank.getClientList()) {
			System.out.println(client);
		}
	}
}
