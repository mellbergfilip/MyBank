package com.ya.mybank.util;

import com.ya.mybank.account.CheckingAccount;
import com.ya.mybank.bank.Bank;
import com.ya.mybank.person.Client;

/*
 * Class with static methods,
 * that handle different kinds of incorrect input from user
 */
public class InputSafetyChecker {

	// Private constructor so object can't be created
	private InputSafetyChecker() {
		super();
	}

	// Methods that read accountNr and loop until correct format
	public static String readCorrectAccountNr() {
		String chosenAccountNr = InputScanner.scan.nextLine();
		while (!isCorrectAccountNr(chosenAccountNr)) {
			System.out.println("\nWrong format for chosen accountnumber. Please try again.");
			System.out.print("Accountnumber: ");
			chosenAccountNr = InputScanner.scan.nextLine();
		}
		return chosenAccountNr;
	}

	/*
	 * Method that checks if correct format for account nr 
	 * Return true or false
	 * Method used in readCorrectAccountNr()
	 */
	private static boolean isCorrectAccountNr(String accountNr) {
		CheckingAccount tempAccount = new CheckingAccount("111111-1");
		boolean correctFormat = false;
		try {
			tempAccount.setAccountNr(accountNr);
			ConsoleOutput.thankYouPleaseWait();
			return correctFormat = true;
		} catch (Exception e) {

		}
		return correctFormat;
	}

	// Methods that read depositsum and loop until correct format
	public static double readCorrectDepositSum() {
		double chosenSum = InputScanner.scan.nextDouble();
		while (!isCorrectDepositSum(chosenSum)) {
			ConsoleOutput.thankYouPleaseWait();
			System.out.println("\nYou can't deposit a negative sum. Try again.");
			System.out.print("Enter amount ($): ");
			chosenSum = InputScanner.scan.nextDouble();
		}
		return chosenSum;
	}

	/*
	 * Method that checks if correct format for deposit sum 
	 * Return true or false
	 * Method used in readCorrectDepositSum()
	 */
	private static boolean isCorrectDepositSum(double sum) {
		CheckingAccount tempAccount = new CheckingAccount("111111-5");
		boolean correctFormat = false;
		try {
			tempAccount.deposit(sum);
			ConsoleOutput.thankYouPleaseWait();
			return correctFormat = true;
		} catch (Exception e) {

		}
		return correctFormat;
	}

	// Methods that read withdraw sum and loop until correct format
	public static double readCorrectWithdrawSum() {
		double chosenSum = InputScanner.scan.nextDouble();
		while (!isCorrectWithdrawSum(chosenSum)) {
			ConsoleOutput.thankYouPleaseWait();
			System.out.println("\nYou can't withdraw more than you have or a negative sum.");
			System.out.print("Enter amount ($): ");
			chosenSum = InputScanner.scan.nextDouble();
		}
		return chosenSum;
	}

	/*
	 * Method that checks if correct format for withdraw sum
	 * Return true or false
	 * Method used in readCorrectWithdrawSum()
	 */
	private static boolean isCorrectWithdrawSum(double sum) {
		CheckingAccount tempAccount = new CheckingAccount("111111-5");
		boolean correctFormat = false;
		try {
			tempAccount.withdraw(sum);
			ConsoleOutput.thankYouPleaseWait();
			return correctFormat = true;
		} catch (Exception e) {

		}
		return correctFormat;
	}

	/* 
	 * Method that checks if accountNr already exists within bank clients
	 * Return true or false
	 */
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

	/*
	 * Method that asks user if previous input look correct 
	 * Print out relevant user input information before using this method
	 * Takes yes or no input from user
	 * Return true or false
	 */
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

	// Method that reads int and loop until int
	public static int readInt() {
		while (!InputScanner.scan.hasNextInt()) {
			InputScanner.scan.nextLine();
			System.out.print("Invalid input. Try again: ");
		}
		int chosenInt = InputScanner.scan.nextInt();
		InputScanner.scan.nextLine();
		return chosenInt;
	}

}
