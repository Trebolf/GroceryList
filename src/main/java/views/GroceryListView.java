package views;

import models.GroceryItem;
import models.GroceryList;
import services.GroceryItemService;
import services.GroceryListService;

import java.util.Scanner;

public class GroceryListView {
    public static void view(Integer id) {
        /*Scanner sc = new Scanner(System.in);
        GroceryItemService groceryItemService = new GroceryItemService();
        GroceryListService groceryListService = new GroceryListService();
        GroceryList groceryList = new GroceryList();
        Boolean running = true;

        while(running) {

            String input = sc.nextLine();
            switch (input) {
                case "1":
                    System.out.println(groceryItemService.getAllItemsGivenListId(groceryList.getId()));
                    break;
                case "2":
                    GroceryItem gi = new GroceryItem();
                    System.out.println("Item Name: ");
                    gi.setName(sc.nextLine());

                    System.out.println("Quantity: ");
                    String quantity = sc.nextLine();

                    if (!quantity.equals("n")) {
                        gi.setQuantity(Integer.parseInt(quantity));
                    }
                    gi.setListId(groceryList.getId());

                    groceryItemService.createItem(gi);
                    System.out.println(gi.getName() + " was added to to list " + groceryList.getName());
                    break;
                case "3":
                    System.out.println(groceryItemService.getAllItemsGivenListId());
                    System.out.println("Item ID: ");
                    String itemId = sc.nextLine();
                    System.out.println("Item ID " + itemId + " is now in cart.");
                case "4":
                    System.out.println(groceryItemService.getAllItemsGivenListId());
                    System.out.println("Item ID: ");
                    String itId = sc.nextLine();

                    groceryItemService.deleteItemInCart(Integer.parseInt(itId));
                    System.out.println("Item ID " + itId + " was deleted.");
                case "0":
                    running = false;
            }
        }*/
    }
}
