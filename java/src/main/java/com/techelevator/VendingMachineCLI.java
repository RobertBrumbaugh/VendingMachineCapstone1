package com.techelevator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import com.techelevator.MoneyHolder;
import com.techelevator.PurchasableItems;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	private static final String PURCHASE_MENU_OPTION_FEEDING_MONEY = "Feeding Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, 
			MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEEDING_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, 
			PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private Menu menu;


	private List<PurchasableItems> vendingItems = new ArrayList<>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	private Inventory inventory = new Inventory();

	private MoneyHolder moneyHolder = new MoneyHolder();

	public VendingMachineCLI() {

	}

	public void run() throws FileNotFoundException {

		TreeMap<String, PurchasableItems> inventorySelection = new TreeMap<>();

		List<PurchasableItems> purchasableItems = inventory.loadItems();

		for(PurchasableItems vendingItem : purchasableItems) {
			inventorySelection.put(vendingItem.getidNum(), vendingItem);
		}

		try {
			vendingItems = inventory.loadItems();
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find inventory file");
		}


		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println("-----| Vendo-Matic's Premium Products |-----");

				//Implement output of items from inventory

				for(PurchasableItems item : vendingItems)
				{
					System.out.println(item.toString());

				}


			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {


				while(true) {
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FEEDING_MONEY)) {

						//Ask user for money and update balance

						System.out.println("Please Insert $: We accept $10, $5, $2, and $1 ");
						Scanner userInput = new Scanner(System.in);
						String input = userInput.nextLine();
						int amountDeposited = Integer.parseInt(input);
						moneyHolder.depositedMoneyConvertedToPennies(amountDeposited);
						System.out.println("Current Money Provided: $" + moneyHolder.balance);

					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

						//print out list of items again
						for(PurchasableItems item : vendingItems)
						{
							System.out.println(item.toString());
						}
						//while itemChoice ==null{
						// check for valid entry} will surround try catch to get the expection.
						String itemChoice = menu.getItemChoice();
						PurchasableItems chosenItem = inventorySelection.get(itemChoice);
						//(varible)cart.addchosenItem (can see the items)
						//if(chosenItem >= moneyHolder.balance) {
						//if greater than balance to cannot but
						//} else if(//check for choiceitem.getcount) {
						//if out of stock, check for this
						//} else{
						//check for decreasing stock(chosenitem.decreaseCount) update balance to charge money
						//} print out the saying 
						//a shopping cart variable to add items(ArrayList)
						//for each loop vendingmaitems: itemOfTheCart{
						// sout items}


					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

						int balance = 0;
						moneyHolder.convertToCoins(balance);
						System.out.println("Thank you, goodbye!");
						System.exit(1);

					}
				}

				// do purchase
			} else if(choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Thank you, goodbye!");
				System.exit(1);

			}
		}
	}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		try {
			cli.run();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}





