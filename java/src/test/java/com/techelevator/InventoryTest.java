package com.techelevator;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {
	
	Inventory INV = new Inventory();
	

	@Test
	public void test_01_Stock_Inventory() {
		
		try {
			INV.loadItems();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean expected = true;
		boolean actual = INV.distributeProductAmount("D2");
		
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void test_02_Getting_List() {
		
		try {
			INV.loadItems();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//int expected = ;
		List<PurchasableItems> actual = INV.getPurchasableItems();
		Assert.assertNotNull(actual);
		
		Assert.assertNotEquals(0, actual.size());
		
	} 
	
	@Test
	public void test_03_Getting_Message() {
		
		try {
			INV.loadItems();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PurchasableItems items = new Candy("B1", "Moonpie", "1.80", "Candy", 5);
		
		String expected = "Munch Munch, Yum!, Thank you! \n";
		String actual = INV.getMessage(true, items);
		
		
		Assert.assertEquals(expected, actual);
		
	} 
	
	@Test
	public void test_04_Getting_False_Message() {
		
		try {
			INV.loadItems();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PurchasableItems items = new Candy("B1", "Moonpie", "1.80", "Candy", 5);
		
		String expected = "Sorry, item is SOLD OUT! \n";
		String actual = INV.getMessage(true, items);
		
		
		Assert.assertNotEquals(expected, actual);
		
	}

}
