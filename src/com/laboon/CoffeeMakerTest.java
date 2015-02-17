package com.laboon;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeMakerTest {

	//Tests that runArgs() returns 0 when any argument is passed
	@Test
	public void testAnyArg() {
		CoffeeMaker cm= new CoffeeMaker();
		assertEquals(0, cm.runArgs("anything"));
	}

}
