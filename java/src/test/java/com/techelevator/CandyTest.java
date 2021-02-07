package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CandyTest {
	
	Candy candyTest;
	
	@Before
	public void setup() {
		candyTest = new Candy("B1", "Moonpie", "1.80", "Candy", 5);
	}

	@Test
	public void test_01_Checking_Price() {
		
		Assert.assertEquals("1.80", candyTest.getPriceString());
	}
	
	@Test
	public void test_02_Checking_Sound() {
		Assert.assertEquals("Munch Munch, Yum!", candyTest.getSound());
	}
	
	@Test
	public void test_03_Checking_Name() {
		Assert.assertEquals("Moonpie", candyTest.getName());
	}
	
//	@Test
//	public boolean test_03_Checking_Stock() {
//		candyTest.decreaseCount();
//		candyTest.decreaseCount();
//		candyTest.decreaseCount();
//		candyTest.decreaseCount();
//		candyTest.decreaseCount();
//		candyTest.decreaseCount();
//		assert.assertEquals(0, candyTest.getCount());
//	}

}
