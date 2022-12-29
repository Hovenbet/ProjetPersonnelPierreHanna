package main;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
  private ArrayList<MenuItem> items;

  public Menu() {
	  
    this.items = new ArrayList<MenuItem>();

    // Add default menu items
    this.items.add(new MenuItem("Burger", 10));
    this.items.add(new MenuItem("Pizza", 12));
    this.items.add(new MenuItem("Salad", 8));
    this.items.add(new MenuItem("Soup", 6));
    this.items.add(new MenuItem("Sandwich", 8));
    this.items.add(new MenuItem("Steak", 20));
    this.items.add(new MenuItem("Pasta", 10));
    this.items.add(new MenuItem("Fish", 15));
    this.items.add(new MenuItem("Rice", 6));
    this.items.add(new MenuItem("Noodles", 8));
    
    MenuItem item = this.items.get(0);
    item.addRawMaterial("Bun", 50);
    item.addRawMaterial("Patty", 200);
    item.addRawMaterial("Lettuce", 50);
    item.addRawMaterial("Tomato", 50);
    item.addRawMaterial("Cheese", 100);

    item = this.items.get(1);
    item.addRawMaterial("Dough", 50);
    item.addRawMaterial("Sauce", 50);
    item.addRawMaterial("Cheese", 100);
    item.addRawMaterial("Pepperoni", 100);

    item = this.items.get(2);
    item.addRawMaterial("Lettuce", 50);
    item.addRawMaterial("Tomato", 50);
    item.addRawMaterial("Carrots", 50);
    item.addRawMaterial("Cucumber", 50);
    item.addRawMaterial("Dressing", 50);

    item = this.items.get(3);
    item.addRawMaterial("Broth", 50);
    item.addRawMaterial("Veggies", 50);
    item.addRawMaterial("Meat", 200);

    item = this.items.get(4);
    item.addRawMaterial("Bread", 50);
    item.addRawMaterial("Meat", 200);
    item.addRawMaterial("Cheese", 100);
    item.addRawMaterial("Lettuce", 50);
    item.addRawMaterial("Tomato", 50);

    item = this.items.get(5);
    item.addRawMaterial("Steak", 500);
    item.addRawMaterial("Potatoes", 50);
    item.addRawMaterial("Veggies", 50);

    item = this.items.get(6);
    item.addRawMaterial("Pasta", 50);
    item.addRawMaterial("Sauce", 50);
    item.addRawMaterial("Meat", 200);

    item = this.items.get(7);
    item.addRawMaterial("Fish", 300);
    item.addRawMaterial("Rice", 50);
    item.addRawMaterial("Veggies", 50);

    item = this.items.get(8);
    item.addRawMaterial("Rice", 50);
    item.addRawMaterial("Meat", 200);
    item.addRawMaterial("Veggies", 50);
    
    item = this.items.get(9);
    item.addRawMaterial("Pasta", 50);
    item.addRawMaterial("Sauce", 50);
    item.addRawMaterial("Meat", 200);


  }
  
  
  public ArrayList<MenuItem> getItems() {
    return this.items;
  }
  public MenuItem getItemByName(String name) {
	    for (MenuItem item : this.items) {
	      if (item.getName().equalsIgnoreCase(name)) {
	        return item;
	      }
	    }
	    return null;
	  }
  public void addItem(MenuItem item) {
    this.items.add(item);
  }

  public void addItemFromUser() {
	  Scanner input = new Scanner(System.in);
	  System.out.print("Enter the name of the menu item: ");
	  String name = input.nextLine();
	  System.out.print("Enter the cost of the menu item: ");
	  int cost = input.nextInt();
	  input.nextLine(); // Consume the newline character
	  MenuItem item = new MenuItem(name, cost);

	  String material;
	  do {
	    System.out.print("Enter a raw material for the item (enter 'done' when finished): ");
	    material = input.nextLine();
	    if (!material.equalsIgnoreCase("done")) {
	      System.out.print("Enter the cost of the raw material: ");
	      int materialCost = input.nextInt();
	      input.nextLine(); // Consume the newline character
	      item.addRawMaterial(material, materialCost);
	    }
	  } while (!material.equalsIgnoreCase("done"));

	  this.items.add(item);
	}

}
