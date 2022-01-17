package com.fm.mybank.util;

/*
 * Class with static methods,
 * that prints out different various
 * console prints for display
 */
public class ConsolePrinter {

	// Private constructor so object can't be created
	private ConsolePrinter() {
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
	
	// Method that prints out long line after printed menu
	public static void dottedLine() {
		System.out.println("----------------------------\n");
	}
}
