package com.techelevator;

public class MoneyBox {
	
	public int balance;
	
	// need a balance ==> converts to pennies
	// needs to add money (deposit - user's current balance)
	// + from user input 
	// needs to withdraw money
	// return change as pennies
	// convert pennies to quarters, dimes, nickels
	// update to 0 after each transaction

	public MoneyBox() {
		balance = 0;
	}
	
	public void depositMoney ( int amountDeposited) {
		balance += amountDeposited;
	}
	
	public void withdrawMoney ( int amountWithdrawn) {
		balance -= amountWithdrawn;
	}
	

	
	

}
