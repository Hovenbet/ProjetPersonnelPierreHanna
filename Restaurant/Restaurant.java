package Restaurant;

import java.util.Map;
import java.util.Scanner;

import main.Menu;
import main.Waiter;

public class Restaurant {
  public static void main(String[] args) {
    Menu menu = new Menu();
    Waiter waiter = new Waiter(menu);

    // Display the menu
    waiter.viewMenu();

    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("What would you like to do?");
      System.out.println("1. View menu");
      System.out.println("2. Place order");
      System.out.println("3. Add item to menu");
      System.out.println("4. Exit");
      System.out.println("5. View raw materials of a menu item");
      System.out.println("6. Update raw materials of a menu item");
      System.out.print("> ");
      int choice = input.nextInt();
      input.nextLine(); // Consume the newline character
      switch (choice) {
        case 1:
          waiter.viewMenu();
          break;
        case 2:
          waiter.placeOrder();
          break;
        case 3:
          menu.addItemFromUser();
          break;
        case 4:
          break;
        case 5:
        	waiter.viewRawMaterials(menu, input);
          break;

        case 6:
        	waiter.updateRawMaterials(menu, input);
        	  break;

        default:
          System.out.println("Invalid choice. Please try again.");
          break;
      }
    }

  }


}
