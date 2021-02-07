package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DrinksTest {

	Drinks drinkTest;
	
	@Before
	public void setup() {
		drinkTest = new Drinks("C1", "Cola", "1.25", "Drink", 5);
	}

	@Test
	public void test_01_Checking_Price() {
		Assert.assertNotSame("1.50", drinkTest.getPriceString());
	}
	
	@Test
	public void test_02_Checking_Sound() {
		Assert.assertEquals("Gulp Gulp, Yum!", drinkTest.getSound());
	}

}
