package com.fm.mybank.bank;

import java.util.List;

import com.fm.mybank.account.BankAccount;
import com.fm.mybank.person.Client;

/*
 * View class that has
 * various methods for printing
 * information related to bank
 */
public class BankView {

	// Method that prints out clientlist, clientinfo (account, nr, name) to console
	public void printClientInfoList(List<Client> clientList) {
		System.out.println("------ CLIENTLIST ----------");
		for (Client client : clientList) {
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
	public void printClientNameList(List<Client> clientList) {
		int i = 1;
		System.out.println("\n------ CLIENTLIST ----------");
		for (Client client : clientList) {
			System.out.println(i + ". " + client.getFirstName() + " " + client.getLastName());
			i++;
		}
	}

	// Method that prints out clientInfo to console
	public void printClientInfo(String firstName, String lastName) {
		System.out.println("\n------ CLIENT INFO ----------");
		System.out.println("Name:" + firstName + " " + lastName);
	}

	// Method that prints out "Welcome to bankname & city"
	public void printWelcomeMessage(String name, String city) {
		System.out.println("Welcome to " + name + "! The best bank in " + city + ".\n");
	}
}
