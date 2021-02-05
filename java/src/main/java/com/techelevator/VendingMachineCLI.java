package com.techelevator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//import com.techelevator.Inventory;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String MAIN_MENU_OPTION_FEEDING_MONEY = "Feeding Money";
	private static final String MAIN_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String MAIN_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, 
			MAIN_MENU_OPTION_EXIT};
	private static final String[] PURCHASE_MENU_OPTIONS = {MAIN_MENU_OPTION_FEEDING_MONEY, MAIN_MENU_OPTION_SELECT_PRODUCT, 
			MAIN_MENU_OPTION_FINISH_TRANSACTION};

	private Menu menu;
	
	private List<PurchasableItems> vendingItems = new ArrayList<>();

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	private Inventory inventory = new Inventory();

	public VendingMachineCLI() {

	}

	public void run() {
		
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
				
				
				if(choice.equals(MAIN_MENU_OPTION_FEEDING_MONEY)) {
					System.out.println("Insert $:  Accepts $10, $5, $1 ");

				} else if (choice.equals(MAIN_MENU_OPTION_SELECT_PRODUCT)) {

				} else if (choice.equals(MAIN_MENU_OPTION_FINISH_TRANSACTION)) {

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
		cli.run();


	}


}





