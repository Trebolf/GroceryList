package services;

import models.GroceryList;
import repositories.GroceryListDAO;
import repositories.GroceryListDAOImplement;

import java.util.List;

public class GroceryListService {

    private GroceryListDAO groceryListDAO;

    public GroceryListService() {
        this.groceryListDAO = new GroceryListDAOImplement();
    }

    public GroceryListService(GroceryListDAO groceryListDAO) {
        this.groceryListDAO = groceryListDAO;
    }

    public List<GroceryList> getAllGivenUserId(Integer userId) {
        return this.groceryListDAO.getAllListsGivenUserId(userId);
    }

    public void createList(GroceryList groceryList) {
        this.groceryListDAO.createList(groceryList);
    }

    public void deleteList(Integer listId) {
        this.groceryListDAO.deleteList(listId);
    }




}
