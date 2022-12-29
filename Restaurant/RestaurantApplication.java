package Restaurant;


import java.util.Scanner;

import main.EditMaterial;

public class RestaurantApplication {
  public static void run() {
    Restaurant restaurant = new Restaurant();
    Scanner input = new Scanner(System.in);
    boolean running = true;
    while (running) {
      System.out.println("What would you like to do?");
      System.out.println("1. View menu");
      System.out.println("2. Place an order");
      System.out.println("3. Display raw materials of a menu item");
      System.out.println("4. Exit");
      int choice = input.nextInt();
      input.nextLine();
      switch (choice) {
        case 1:
          restaurant.getWaiter().viewMenu();
          break;
        case 2:
          restaurant.getWaiter().placeOrder();
          break;
        case 3:
          System.out.print("Enter the name of the menu item: ");
          String itemName = input.nextLine();
          EditMaterial item = restaurant.getMenu().getItemByName(itemName);
          if (item == null) {
            System.out.println("Menu item not found.");
          } else {
            System.out.println("Raw materials for " + item.getName() + ":");
            for (String material : item.getRawMaterials().keySet()) {
              System.out.println(material + " - $" + item.getRawMaterials().get(material));
            }
          }
          break;
        case 4:
          running = false;
          break;
        default:
          System.out.println("Invalid option.");
          break;
      }
    }
  }
}