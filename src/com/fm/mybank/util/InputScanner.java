package com.fm.mybank.util;

import java.util.Scanner;

/*
 * Class that holds a public static scanner,
 * available for all classes for flexibility purposes 
 */
public class InputScanner {

	public static Scanner scan = new Scanner(System.in);

	// Private constructor so object can't be created
	private InputScanner() {
		super();
	}

}
