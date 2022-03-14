package views;

import models.User;
import services.UserService;

import java.util.Scanner;

public class Register {
    public static void view() {
        UserService userService = new UserService();
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("First name: ");
        String firstName = sc.nextLine();

        System.out.print("Last name: ");
        String lastName = sc.nextLine();

        User user = userService.validateCredentials(username, password);

        userService.createUser(new User(username, password, firstName, lastName));
    }
};
