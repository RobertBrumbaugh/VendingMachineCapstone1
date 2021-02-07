package com.techelevator;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineCLITest {

	VendingMachineCLI VM = new VendingMachineCLI();
	
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
	public void test_01_Check_Balance_With_Money() {
		
	Gum	chosenItem = new Gum("D2", "U Chew", "0.95", "Gum", 5);
		
	MoneyHolder moneyHolder = new MoneyHolder();
	moneyHolder.balance = 10;
	double chosenItemPriceToDouble = Double.valueOf(chosenItem.getPriceString());
	
	
	String expectedresult = "Current Balance: $" + String.format("%.2f", moneyHolder.balance - chosenItemPriceToDouble);
	String actualresult = VM.checkBalance(chosenItem, moneyHolder);
	
	Assert.assertEquals(expectedresult, actualresult);
	
	}
	
	@Test
	public void test_02_Check_Balance_Without_Enough_Money() {
		
	Gum	chosenItem = new Gum("D2", "U Chew", "0.95", "Gum", 5);
		
	MoneyHolder moneyHolder = new MoneyHolder();
	moneyHolder.balance = 0;
	double chosenItemPriceToDouble = Double.valueOf(chosenItem.getPriceString());
	
	
	String expectedresult = "Insufficient Funds!";
	String actualresult = VM.checkBalance(chosenItem, moneyHolder);
	
	Assert.assertEquals(expectedresult, actualresult);
	
	}
}
