package com.techelevator;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PurchasableItemsTest {
	
	PurchasableItems PIT = new PurchasableItems("idNum", "name", "price", "type", 5);
	
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

	@Test
	public void test_01_PurchasableItems_Checking_Decrease_Count() {
		
		Assert.assertEquals(4, PIT.decreaseCount());
	}
//	
//	@Test
//	public void test_02_PurchasableItems_Checking_Display_String() {
//		
//		PIT.toString();
//		
//		Assert.assertEquals("A1) Potato Crisps -- $ 3.05 -- 5 Available", testing.toString().trim());
//	}

}
