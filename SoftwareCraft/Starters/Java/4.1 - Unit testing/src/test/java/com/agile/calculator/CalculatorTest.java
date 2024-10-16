package com.agile.calculator;

import static org.junit.Assert.*;


import org.junit.Test;


public class CalculatorTest {
	
	@Test
	public void subtractionTest(){
		Calculator c = new Calculator();
		int expected = 3;
		int actual = c.subtract("6,3");
		assertEquals(expected,actual);
	}
	
	@Test
	public void multiplyTest(){
		Calculator c = new Calculator();
		int expected = 12;
		int actual = c.multiply("4,3");
		assertEquals(expected,actual);
	}
	
	@Test
	public void divideTest(){
		Calculator c = new Calculator();
		int expected = 4;
		int actual = c.divide("12,3");
		assertEquals(expected,actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		Calculator c = new Calculator();
		try{
			c.divide("12,0");
		} catch(Exception IllegalArgumentException) {
			System.out.println("Something went wrong.");
		}
	}
	
	
}
