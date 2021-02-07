package com.techelevator;

import org.junit.Assert.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoneyHolderTest {
	
	MoneyHolder MHT = new MoneyHolder();
	
	private  ByteArrayOutputStream testing = new ByteArrayOutputStream();
	private  PrintStream clearing = System.out;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(testing));
	}

	@After
	public void restoreStreams() {
		System.setOut(clearing);
	}
	
//	@Test
//	public void test_01_dispenseTest() {
//		betesCrunch.dispense();
//		Assert.assertEquals("You have purchased: BetesCrunch for $9.99\nMunch Munch, Yum!", test01dispense.toString().trim());
//	}
	
	int validNumber = 10;
	int invalidNumber = 3;
	
	@Test
	public void test_01_depositedMoneyConvertedToPennies_3() {
		
		MHT.depositedMoneyConvertedToPennies(invalidNumber);
		
		Assert.assertEquals("Invalid entry: Please Enter $1, $2, $5, or $10", 
				testing.toString().trim());
		
	}
	
	@Test
	public void test_02_depositedMoneyConvertedToPennies_10() {
		
		MHT.depositedMoneyConvertedToPennies(validNumber);
		
		Assert.assertEquals((double) 10.00, MHT.getBalance(), 0);
		
	}
	
	@Test
	public void test_03_depositedMoneyConvertedToPennies_40cent() {
		
		
		MHT.convertToCoins((double) 40);
		
		Assert.assertEquals("Dispensing: 1 Quarters, 1 Dimes, 1 Nickels", testing.toString().trim());
		
	}
	

}
