package com.ya.mybank.util;

import com.ya.mybank.bank.Bank;

public class ConsoleOutput {

	// private constructor so object can't be created
	private ConsoleOutput() {
		super();
	}

	// printout Thank you please wait ........ with threadsleep
	public static void thankYouPleaseWait() {
		try {
			System.out.println("\nThank you. Please wait a few seconds.");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". \n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// printout Shutting down ........ with threadsleep
	public static void shuttingDown() {
		try {
			System.out.println("Shutting down");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			Thread.sleep(700);
			System.out.print(". ");
			System.out.println("System down.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// printout Welcome to bankname & city
	public static void welcomeMessage(Bank bank) {
		System.out.println("Welcome to " + bank.getName() + "! The best bank in " + bank.getCity() + ".\n");
	}
	
	//printout long line used in menu
	public static void dottedLine() {
		System.out.println("----------------------------\n");
	}
}
