package com.ppdai.tutorial;
import java.util.regex.Pattern;

/**
 * 
 * @author CS2334, modified by ??
 * @version 2016-09-22 Lab 5
 * 
 *          The Calculator class provides functionality for parsing input
 *          strings that contain simple expressions and for computing the result
 *          of the expression.
 *
 */
public class Calculator {
	/**
	 * Compute the result of the expression encoded in a sequence of tokens.
	 * 
	 * Here are the different cases:
	 *  
	 * 0 tokens: CalculatorException: "Illegal input." 
	 * 
	 * 1 token: "quit" (any casing): CalculatorException: "Exit." with quit = true 
	 * All other cases: CalculatorException: "Illegal input." 
	 * 
	 * 2 tokens: "-" and any number: return negative of number
	 * "-" and not a number: CalculatorException: "Illegal argument." 
	 * other string and any string: CalculatorException: "Illegal operator." 
	 * 
	 * 3 tokens:
	 * number1, "+", number2: return sum of two numbers 
	 * number1, "-", number2: return difference of two numbers (number1 - number2) 
	 * number1, "*", number2: return product of two numbers 
	 * number1, "/", zero:  CalculatorException: "Divide by zero error." 
	 * number1, "/", not zero: return number1/number2 
	 * number1, "%", zero: CalculatorException: "Mod by zero error." 
	 * number1, "%", not zero: return number1%number2
	 *  
	 * not a number, anything, anything: CalculatorException: "Illegal argument."
	 * number1, anything, not a number: CalculatorException: "Illegal argument."
	 * number1, not an operator, number2: CalculatorException: "Illegal operator." 
	 * 
	 * 4 or more tokens: CalculatorException:
	 * "Illegal input."
	 * 
	 * @param tokens
	 *            The array of tokens to evaluate
	 * @return int result of evaluating the expression
	 * @throws CalculatorException
	 *             If some form of error has been generated or "quit" has been
	 *             typed
	 */
	public static int compute(String[] tokens) throws CalculatorException  {
		// Condition on the number of tokens
		switch (tokens.length) {
		
		case 0:
			throw new CalculatorException("Illegal input.");
			
		case 1:
			String token = tokens[0].trim();
			if (token.equalsIgnoreCase("QUIT")) {
				throw new CalculatorException("Exit", true);
			} else {
				throw new CalculatorException("Illegal input.");
			}
			
		case 2:
			String operator = tokens[0].trim();
			String number = tokens[1].trim();
						
			Pattern pattern = Pattern.compile("[0-9]*");  
		    boolean flag = pattern.matcher(number).matches();
			
			if(operator.equals("-") && flag) {
				int num = Integer.parseInt(number);
				return -num;
			}else if(operator.equals("-") && !flag) {
				throw new CalculatorException("Illegal argument.");
			}else {
				throw new CalculatorException("Illegal operator.");
			}
			
		case 3:
			String num1 = tokens[0].trim();
			String ope = tokens[1].trim();
			String num2 = tokens[2].trim();
			
			Pattern pattern1 = Pattern.compile("[0-9]*");  
		    boolean flag1 = pattern1.matcher(num1).matches();
		    boolean flag2 = pattern1.matcher(num1).matches();
		    
		    int intnum1 = 0;
		    int intnum2 = 0;
		    
		    if(flag1) {
		    	intnum1 = Integer.parseInt(num1);
		    }
		    
		    if(flag2) {
		    	intnum2 = Integer.parseInt(num2);
		    }
		    
		    if(flag1) {
		    	if(flag2) {
			    	if(ope.equals("+")) {
			    		return intnum1 + intnum2;
			    	}else if(ope.equals("-")) {
			    		return intnum1 - intnum2;
			    	}else if(ope.equals("*")){
			    		return intnum1 * intnum2;
			    	}else if(ope.equals("/") && intnum2 == 0) {
			    		throw new CalculatorException("Divide by zero error.");
			    	}else if(ope.equals("/") && intnum2 != 0) {
			    		return intnum1 / intnum2;
			    	}else if(ope.equals("%") && intnum2 == 0) {
			    		throw new CalculatorException("Mod by zero error.");
			    	} else if(ope.equals("%") && intnum2 != 0) {
			    		return intnum1 % intnum2;
			    	} else {
			    		throw new CalculatorException("Illegal operator.");
			    	}
		    	}else {
		    		throw new CalculatorException("Illegal argument.");
		    	}
		    			    	
		    	
		    }else {
		    	throw new CalculatorException("Illegal argument.");
		    }
			
		default:
			// 4 or more tokens
			throw new CalculatorException("Illegal input.");
		}

	}

	/**
	 * Parse the input string as an expression and evaluate it.
	 * 
	 * If the input is a legal expression, then the result is printed
	 * 
	 * Otherwise a CalculatorException has occurred. Print the exception
	 * message.
	 * 
	 * @param input
	 *            A String possibly containing a mathematical expression
	 * @return true if the String is equal to "quit"; false otherwise
	 */
	public static boolean parseAndCompute(String input) {
		// Pull out the tokens
		
		if(input.trim().equalsIgnoreCase("quit")) {
			return true;
		}
		
		String[] tokens = input.split(" ");
		
		try {
			// TODO: complete implementation
			int result = compute(tokens);
			System.out.println("Compute Result: " + result);
		} catch (CalculatorException e) {
			// TODO: complete 
			e.printStackTrace();
		}

		// Quit has not been specified
		return false;
	}
}
