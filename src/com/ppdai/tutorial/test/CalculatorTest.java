package com.ppdai.tutorial.test;

import org.junit.Assert;
import org.junit.Test;

import com.ppdai.tutorial.Calculator;
import com.ppdai.tutorial.CalculatorException;

public class CalculatorTest {

	/**
	 * Test correct addition
	 * 
	 * @throws CalculatorException
	 *             if an error occurs (not expected)
	 */
	@Test
	public void computeAdditionTest1() throws CalculatorException {
		Assert.assertEquals(9, Calculator.compute(new String[] { "4", "+", "5" }));
	}

	/**
	 * Test quit
	 * 
	 */
	@Test
	public void computeQuitTest1() {
		try {
			int val = Calculator.compute(new String[] { "quit" });
			Assert.fail();
		} catch (CalculatorException e) {
			Assert.assertTrue(e.isQuit());
		}
	}

	@Test
	public void testComputeZeroParam() {
		try {
			int val = Calculator.compute(new String[] {});
			Assert.fail();
		} catch (CalculatorException e) {
			Assert.assertEquals("Illegal input.", e.getMessage());
		}
	}
	/**
	 * Test Single Illegal Arg
	 * 
	 */
	@Test
	public void computeSingleIllegalArgTest() {
		try {
			int val = Calculator.compute(new String[] { "foo" });
			Assert.fail();
		} catch (CalculatorException e) {
			Assert.assertEquals("Illegal input.", e.getMessage());
		}
	}

	@Test
	public void testComputeTwoParam() {

		try {
			int val1 = Calculator.compute(new String[] { "-", "2" });
			Assert.assertEquals(-2, val1);
		} catch (CalculatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			int val2 = Calculator.compute(new String[] { "-", "ss" });
			// Assert.assertEquals(1, val2);
		} catch (CalculatorException e) {
			Assert.assertEquals("Illegal argument.", e.getMessage());
		}

		try {
			int val2 = Calculator.compute(new String[] { "12", "ss" });
			// Assert.assertEquals(1, val2);
		} catch (CalculatorException e) {
			Assert.assertEquals("Illegal operator.", e.getMessage());
		}

	}

	@Test
	public void testComputeThreeParam() {
		try {
			int val1 = Calculator.compute(new String[] { "1", "+", "2" });
			Assert.assertEquals(3, val1);
			int val2 = Calculator.compute(new String[] { "1", "-", "2" });
			Assert.assertEquals(-1, val2);

			int val3 = Calculator.compute(new String[] { "1", "*", "2" });
			Assert.assertEquals(2, val3);

			int val4 = Calculator.compute(new String[] { "1", "/", "2" });
			Assert.assertEquals(0, val4);

			int val5 = Calculator.compute(new String[] { "1", "%", "2" });
			Assert.assertEquals(1, val5);

		} catch (CalculatorException e) {
			e.printStackTrace();
		}

		try {
			int val6 = Calculator.compute(new String[] { "1", "/", "0" });
			Assert.assertEquals(1, val6);
		} catch (CalculatorException e) {
			Assert.assertEquals("Divide by zero error.", e.getMessage());
		}

		try {
			int val7 = Calculator.compute(new String[] { "1", "%", "0" });
			Assert.assertEquals(1, val7);
		} catch (CalculatorException e) {
			Assert.assertEquals("Mod by zero error.", e.getMessage());
		}

		try {
			int val8 = Calculator.compute(new String[] { "1", "%", "s" });
			Assert.assertEquals(1, val8);
		} catch (CalculatorException e) {
			Assert.assertEquals("Illegal argument.", e.getMessage());
		}

		try {
			int val9 = Calculator.compute(new String[] { "s", "%", "s" });
			Assert.assertEquals(1, val9);
		} catch (CalculatorException e) {
			Assert.assertEquals("Illegal argument.", e.getMessage());
		}

		try {
			int val10 = Calculator.compute(new String[] { "asdf", "s", "%", "s" });
			Assert.assertEquals(1, val10);
		} catch (CalculatorException e) {
			Assert.assertEquals("Illegal input.", e.getMessage());
		}
	}

	/**
	 * Test parseAndCompute: addition
	 * 
	 * @throws CalculatorException
	 *             if an error occurs (not expected)
	 */
	@Test
	public void parseAndComputeAddition() {
		Assert.assertFalse(Calculator.parseAndCompute("4 + 2"));
		Assert.assertFalse(Calculator.parseAndCompute("4 f 2"));
		Assert.assertTrue(Calculator.parseAndCompute("quit"));
	}

}
