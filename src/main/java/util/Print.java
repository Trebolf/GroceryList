package util;

import models.GroceryList;
import models.User;

public class Print {
    public static void landing() {
        System.out.println("*** Grocery App ***");
        System.out.println("1) Login");
        System.out.println("2) Register");
        System.out.println("0) Exit");
    }

    public static void dashbboard(User user) {
        System.out.println("Welcome, " + user.getFirstName() + " " + user.getLastName() + "!");
        System.out.println("1) Display all of " + user.getFirstName() + "'s lists.");
        System.out.println("2) Go to a specific list.");
        System.out.println("3) Create a new list.");
        System.out.println("4) Delete a list.");
        System.out.println("0) Logout");
    }

    public static void itempage(GroceryList groceryList) {
        System.out.println(groceryList.getName());
        System.out.println("1) Display all items.");
        System.out.println("2) Create Item.");
        System.out.println("3) Mark an Item in Cart.");
        System.out.println("4) Delete an item.");
        System.out.println("0) Back to dashboard.");
    }
}
