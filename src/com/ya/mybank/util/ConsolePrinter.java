package com.ya.mybank.util;

import com.ya.mybank.bank.Bank;

/*
 * Class with static methods,
 * that prints out different various
 * console prints for display
 */
public class ConsoleOutput {

	// Private constructor so object can't be created
	private ConsoleOutput() {
		super();
	}

	// Method that prints out "thankYouPleaseWait......." with Thread.sleep
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
	
	// Method that prints out "Shutting down........" with threadsleep
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
	
	// Method that prints out "Welcome to bankname & city"
	public static void welcomeMessage(Bank bank) {
		System.out.println("Welcome to " + bank.getName() + "! The best bank in " + bank.getCity() + ".\n");
	}
	
	// Method that prints out long line after printed menu
	public static void dottedLine() {
		System.out.println("----------------------------\n");
	}
}
