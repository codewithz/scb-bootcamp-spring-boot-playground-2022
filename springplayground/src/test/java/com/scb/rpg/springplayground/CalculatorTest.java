package com.scb.rpg.springplayground;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.scb.rpg.springplayground.entities.Calculator;

public class CalculatorTest {
	
	Calculator calculator;
	
	@Test
	public void demoTestMethod() {
		assertTrue(true);
	}
	
	@Test
	public void testMultiply() {
		calculator=new Calculator();
		
		assertEquals(20, calculator.multiply(4, 5));
	}

}
