package Restaurant;

import java.util.ArrayList;

import MenuItem;
import Menu;


public class RestaurantOrderingSystem {
  public static void main(String[] args) {
 
    Menu menu = new Menu();
    menu.addItem(new MenuItem("Burger", 10));
    menu.addItem(new MenuItem("Pizza", 12));

    // Allow the user to add an item to the menu
    menu.addItemFromUser();

    // Get the list of menu items
    ArrayList<MenuItem> items = menu.getItems();
    for (MenuItem item : items) {
      System.out.println(item.getName() + " - $" + item.getCost());
      System.out.println("Raw materials:");
      for (String material : item.getRawMaterials().keySet()) {
        System.out.println("- " + material + " - $" + item.getRawMaterials().get(material));
      }
    }
  }
}
