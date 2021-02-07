package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

	Gum gumTest;
	
	@Before
	public void setup() {
		gumTest = new Gum("D1", "U-Chews", "3.05", "Gum", 5);
	}

	@Test
	public void test_01_Checking_Price() {
		Assert.assertNotSame("3.50", gumTest.getPriceString());
	}
	
	@Test
	public void test_02_Checking_Sound() {
		Assert.assertEquals("Chew Chew, Yum!", gumTest.getSound());
	}

}