package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipsTest {

	Chips chipTest;
	
	@Before
	public void setup() {
		chipTest = new Chips("A1", "Potato Crisp", "3.05", "Chip", 5);
	}

	@Test
	public void test_01_Checking_Price() {
		Assert.assertNotSame("3.50", chipTest.getPriceString());
	}
	
	@Test
	public void test_02_Checking_Sound() {
		Assert.assertEquals("Crunch Crunch, Yum!", chipTest.getSound());
	}

}

