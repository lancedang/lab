package com.ppdai.tutorial.test;
import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import com.ppdai.tutorial.Calculator;
import com.ppdai.tutorial.CalculatorException;


public class CalculatorTest {

    /**
     * Test correct addition 
     * 
     * @throws CalculatorException if an error occurs (not expected)
     */
    @Test
    public void computeAdditionTest1() throws CalculatorException {
        Assert.assertEquals(9, Calculator.compute(new String[]{"4", "+", "5"}));
    }

    /**
     * Test quit
     * 
     */
    @Test
    public void computeQuitTest1() {
        try
        {
            int val = Calculator.compute(new String[]{"quit"});
            Assert.fail();
        }
        catch(CalculatorException e)
        {
            Assert.assertTrue(e.isQuit());
        }
    }


    /**
     * Test Single Illegal Arg
     * 
     */
    @Test
    public void computeSingleIllegalArgTest() {
        try
        {
            int val = Calculator.compute(new String[]{"foo"});
            Assert.fail();
        }
        catch(CalculatorException e)
        {
            Assert.assertEquals("Illegal input.", 
                    e.getMessage());
        }
    }



    /**
     * Test parseAndCompute: addition
     * 
     * @throws CalculatorException if an error occurs (not expected)
     */
    @Test
    public void parseAndComputeAddition() {
        Assert.assertFalse(Calculator.parseAndCompute("4 + 2"));
    }

}
