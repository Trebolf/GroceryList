package controllers;

import io.javalin.http.Context;
import models.GroceryList;
import models.JsonResponse;
import services.GroceryListService;

import java.util.List;

public class GroceryListController {
    GroceryListService groceryListService;

    public GroceryListController() {
        this.groceryListService = new GroceryListService();
    }

    public GroceryListController(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    public void displayAllListForUser(Context context) {
        Integer userId = Integer.parseInt(context.pathParam("userId"));

        List<GroceryList> lists = groceryListService.getAllGivenUserId(userId);

        context.json(new JsonResponse(true,"Listing all list for user " + userId, lists));
    }

    public void createList(Context context) {
        GroceryList groceryList = context.bodyAsClass(GroceryList.class);

        groceryListService.createList(groceryList);

        context.json(new JsonResponse(true, "List created for user " + groceryList.getUserId(), null));
    }

    public void deleteList(Context context) {
        Integer listId = Integer.parseInt(context.pathParam("listId"));

        groceryListService.deleteList(listId);

        context.json(new JsonResponse(true, "List ID: " + listId + " deleted (if it existed)", null));
    }
}
