package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.User;
import services.UserService;

public class UserController {
    //reference
    private UserService userService;

    //decouple
    public UserController() {
        this.userService = new UserService();
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(Context context) {
        //get user object from json string = JACKSON
        User user = context.bodyAsClass(User.class);

        //service package
        userService.createUser(user);

        JsonResponse jsonResponse = new JsonResponse(true, "user has been created", null);

        context.json(jsonResponse);
    }

    public void login(Context context) {
        JsonResponse jsonResponse;

        User credentials = context.bodyAsClass(User.class);

        User userFromDB = userService.validateCredentials(credentials.getUsername(), credentials.getPassword());

        if(userFromDB == null) {
            jsonResponse = new JsonResponse(false, "Invalid username or password.", null);
        } else {
            jsonResponse = new JsonResponse(true, "Login successful!", userFromDB);
        }

        context.json(jsonResponse);
    }
}
