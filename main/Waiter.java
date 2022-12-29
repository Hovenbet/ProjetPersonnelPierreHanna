package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Waiter implements RawMaterialOperations {
  private Menu menu;

  public Waiter(Menu menu) {
    this.menu = menu;
  }

  public void viewMenu() {
      System.out.println(" _____ ______   _______   ________   ___  ___     ");
      System.out.println("|\\   _ \\  _   \\|\\  ___ \\ |\\   ___  \\|\\  \\|\\  \\    ");
      System.out.println("\\ \\  \\\\__\\ \\  \\ \\   __/|\\ \\  \\\\ \\  \\ \\  \\\\\\  \\   ");
      System.out.println(" \\ \\  \\\\|__| \\  \\ \\  \\_|/_\\ \\  \\\\ \\  \\ \\  \\\\\\  \\  ");
      System.out.println("  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\ \\  \\\\ \\  \\ \\  \\\\\\  \\ ");
      System.out.println("   \\ \\__\\    \\ \\__\\ \\_______\\ \\__\\\\ \\__\\ \\_______\\");
      System.out.println("    \\|__|     \\|__|\\|_______|\\|__| \\|__|\\|_______|");
      System.out.println("                                                   ");

	  ArrayList<MenuItem> items = menu.getItems();
	  for (MenuItem item : items) {
	    String name = item.getName();
	    String cost = "$" + item.getCost();
	    int namePadding = 30 - name.length();
	    for (int i = 0; i < namePadding; i++) {
	      name += " ";
	    }
	    System.out.println(name + "| " + cost);
	    System.out.println("------------------------------|---------");
	  }
	}



  public void placeOrder() {
	  Scanner input = new Scanner(System.in);
	  Map<MenuItem, Integer> order = new HashMap<>();

	  while (true) {
	    System.out.print("Enter the name of the item to order (or 'done' to finish): ");
	    String itemName = input.nextLine();

	    if (itemName.equalsIgnoreCase("done")) {
	      break;
	    }

	    System.out.print("Enter the quantity of the item: ");
	    int quantity = input.nextInt();
	    input.nextLine();  // Consume the newline character after the quantity

	    // Find the menu item with the specified name
	    MenuItem item = null;
	    for (MenuItem menuItem : menu.getItems()) {
	      if (menuItem.getName().equalsIgnoreCase(itemName)) {
	        item = menuItem;
	        break;
	      }
	    }

	    // If the item was found, add it to the order
	    if (item != null) {
	      order.put(item, quantity);
	    } else {
	      System.out.println("Sorry, the item you requested is not on the menu.");
	    }
	  }

	  // Calculate the total cost of the order
	  int totalCost = 0;
	  for (Map.Entry<MenuItem, Integer> entry : order.entrySet()) {
	    MenuItem item = entry.getKey();
	    int quantity = entry.getValue();
	    totalCost += item.getCost() * quantity;
	  }

	  System.out.println("Placing order for the following items: ");
	  for (Map.Entry<MenuItem, Integer> entry : order.entrySet()) {
	    MenuItem item = entry.getKey();
	    int quantity = entry.getValue();
	    System.out.println(quantity + " x " + item.getName() + " ($" + item.getCost() + " each)");
	  }
	  System.out.println("Total cost: $" + totalCost);
	}

  
  @Override
public void updateRawMaterials(Menu menu, Scanner input) {
	  System.out.print("Enter the name of the menu item: ");
	  String itemName = input.nextLine();
	  MenuItem item = menu.getItemByName(itemName);
	  if (item == null) {
	    System.out.println("Menu item not found.");
	  } else {
	    Map<String, Integer> rawMaterials = item.getRawMaterials();
	    System.out.println("Current raw materials for " + item.getName() + ":");
	    int index = 1;
	    for (String material : rawMaterials.keySet()) {
	      System.out.println(index + ". " + material + " - $" + rawMaterials.get(material));
	      index++;
	    }

	    System.out.print("Enter the number of the raw material you want to update: ");
	    int materialIndex = input.nextInt();
	    input.nextLine(); // Consume the newline character
	    if (materialIndex < 1 || materialIndex > rawMaterials.size()) {
	      System.out.println("Invalid choice. Please try again.");
	    } else {
	      String[] materialArray = rawMaterials.keySet().toArray(new String[0]);
	      String materialToUpdate = materialArray[materialIndex - 1];
	      System.out.print("Enter the new name for the raw material: ");
	      String newName = input.nextLine();
	      System.out.print("Enter the new cost for " + newName + ": ");
	      int newCost = input.nextInt();
	      rawMaterials.remove(materialToUpdate);
	      rawMaterials.put(newName, newCost);
	      System.out.println(materialToUpdate + " updated successfully to " + newName + ".");
	    }
	  }
	}

  
  @Override
public void viewRawMaterials(Menu menu, Scanner input) {
	  System.out.print("Enter the name of the menu item: ");
	  String itemName = input.nextLine();
	  MenuItem item = menu.getItemByName(itemName);
	  if (item == null) {
	    System.out.println("Menu item not found.");
	  } else {
	    System.out.println("Raw materials for " + item.getName() + ":");
	    int index = 1;
	    for (String material : item.getRawMaterials().keySet()) {
	      System.out.println(index + ". " + material + " - $" + item.getRawMaterials().get(material));
	      index++;
	    }
	  }
	}

}
