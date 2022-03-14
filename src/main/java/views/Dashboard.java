package views;

import models.GroceryList;
import models.User;
import services.GroceryItemService;
import services.GroceryListService;
import util.Print;

import java.util.Scanner;

public class Dashboard {
    public static void view(User user) {
        GroceryListService groceryListService = new GroceryListService();
        Scanner sc = new Scanner(System.in);
        Boolean running = true;

        while(running) {
            Print.dashbboard(user);
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    System.out.println(groceryListService.getAllGivenUserId(user.getId()));

                case "2":
                    System.out.println("display specific list");
                    //todo display specific list
                case "3":
                    System.out.print("List Name: ");
                    String name = sc.nextLine();
                    groceryListService.createList(new GroceryList(name, user.getId()));
                    System.out.println("List " + name + " was created!");
                case "4":
                    System.out.println(groceryListService.getAllGivenUserId(user.getId()));
                    System.out.print("List id to be deleted: ");
                    String listId = sc.nextLine();
                    groceryListService.deleteList(Integer.parseInt(listId));
                    break;
                case "0":
                    running = false;
            }
        }
    }
}
