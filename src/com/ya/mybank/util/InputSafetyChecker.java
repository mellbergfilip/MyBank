package com.ya.mybank.util;

import com.ya.mybank.account.CheckingAccount;
import com.ya.mybank.bank.Bank;
import com.ya.mybank.person.Client;

public class InputSafetyChecker {

	// private constructor so object can't be created
	private InputSafetyChecker() {
		super();
	}

	// checks if correct format for account nr
	public static boolean isCorrectAccountNr(String accountNr) {
		CheckingAccount tempAccount = new CheckingAccount("111111-1");
		boolean correctFormat = false;
		try {
			tempAccount.setAccountNr(accountNr);
			ConsoleOutput.thankYouPleaseWait();
			return correctFormat = true;
		} catch (Exception e) {
			System.out.println("\nWrong format for chosen accountnumber. Please try again.");
		}
		return correctFormat;
	}

	// checks if correct deposit sum
	public static boolean isCorrectDepositSum(double sum) {
		CheckingAccount tempAccount = new CheckingAccount("111111-5");
		boolean correctFormat = false;
		try {
			tempAccount.deposit(sum);
			ConsoleOutput.thankYouPleaseWait();
			return correctFormat = true;
		} catch (Exception e) {
			ConsoleOutput.thankYouPleaseWait();
			System.out.println("\nYou can't deposit a negative sum.");
		}
		return correctFormat;
	}

	// checks if correct withdraw sum
	public static boolean isCorrectWithdrawSum(double sum) {
		CheckingAccount tempAccount = new CheckingAccount("111111-5");
		boolean correctFormat = false;
		try {
			tempAccount.withdraw(sum);
			ConsoleOutput.thankYouPleaseWait();
			return correctFormat = true;
		} catch (Exception e) {
			ConsoleOutput.thankYouPleaseWait();
			System.out.println("\nYou can't withdraw more than you have or a negative sum.");
		}
		return correctFormat;
	}

	// Checks if accountNr already exists within bank clients
	public static boolean doExistAccountNr(Bank bank, String accountNr) {
		boolean doExist = false;
		for (Client client : bank.getClientList()) {
			for (int i = 0; i < client.getAccountList().size(); i++) {
				if (accountNr.equals(client.getAccountList().get(i).getAccountNr())) {
					return doExist = true;
				}
			}
		}
		System.out.println("\nThe number you have entered does not exist. Please try again:");
		return doExist;
	}

	// asks if input look correct (print out relevant user input information before)
	public static boolean isThisInfoCorrect() {
		boolean isCorrectInfo = false;
		System.out.println("Is this information correct?\nPress \"y\" to accept and \"n\" to start over. ");
		System.out.print("(y/n): ");
		String yesOrNo = InputScanner.scan.nextLine();
		if (!yesOrNo.toLowerCase().equals("y") && !yesOrNo.toLowerCase().equals("n")) {
			do {
				System.out.println("You can only enter \"y\" or \"n\". Please try again.");
				System.out.print("(y/n): ");
				yesOrNo = InputScanner.scan.nextLine();
			} while (!yesOrNo.toLowerCase().equals("y") || !yesOrNo.toLowerCase().equals("n"));
		}
		System.out.println();
		if (yesOrNo.toLowerCase().equals("y")) {
			return isCorrectInfo = true;
		} else if (yesOrNo.toLowerCase().equals("n")) {
			System.out.println("Please follow all the steps again.\n");
			return isCorrectInfo;
		} else {
			return isCorrectInfo;
		}
	}

	// read int and loop until int
	public static int readInt() {
		while (!InputScanner.scan.hasNextInt()) {
			InputScanner.scan.nextLine();
			System.out.print("Invalid input. Try again: ");
		}
		int chosenInt = InputScanner.scan.nextInt();
		InputScanner.scan.nextLine();
		return chosenInt;
	}

	// read int and loop until int
	public static double readDouble() {
		while (!InputScanner.scan.hasNextDouble()) {
			InputScanner.scan.nextLine();
			System.out.print("Invalid input. Try again: ");
		}
		double chosenDouble = InputScanner.scan.nextDouble();
		InputScanner.scan.nextLine();
		return chosenDouble;
	}
}
