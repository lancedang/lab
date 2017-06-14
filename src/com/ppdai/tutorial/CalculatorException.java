package com.ppdai.tutorial;
/**
 * 
 * @author CS2334. Modified by ???
 * @version 2016-09-22 Lab 5
 * 
 *          Exception class for representing exceptions that can occur within a
 *          calculator.
 * 
 *          This class extends Exception, adding a boolean "quit" flag that
 *          indicates that the user has typed "quit" (in any casing)
 *
 */
public class CalculatorException extends Exception {
	private boolean quit;

	public CalculatorException(String message) {
		super(message);
		this.quit = false;
	}

	public CalculatorException(String message, boolean quit) {
		super(message);
		this.quit = quit;
	}

	// TODO: complete implementation
	public boolean isQuit() {
		return quit;
	}
}
