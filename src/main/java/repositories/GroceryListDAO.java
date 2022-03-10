package repositories;

import models.GroceryList;

import java.util.List;

public interface GroceryListDAO {
    List<GroceryList> getAllListsGivenUserId(Integer userId);
    void createList(GroceryList groceryList);
    void deleteList(GroceryList groceryList);
}
