import models.GroceryItem;
import models.GroceryList;
import models.User;
import repositories.*;

public class MainDriver {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImplement();
        GroceryListDAO groceryListDAO = new GroceryListDAOImplement();
        GroceryItemDAO groceryItemDAO = new GroceryItemDAOImplement();

        //userDAO.createUser(new User("Trebolf", "password1", "Flo", "W"));
        //System.out.println(userDAO.getUserGivenUsername("Trebolf"));

        //groceryListDAO.createList(new GroceryList("Meijer",4));
        //System.out.println(groceryListDAO.getAllListsGivenUserId(4));

        //groceryItemDAO.createItemForListWithoutQuantity(new GroceryItem("Banana", null, 6));
        //groceryItemDAO.createItemForListWithQuantity(new GroceryItem("Grapes", 12, 6));

        //groceryItemDAO.markItemInCart(4);
        groceryItemDAO.deleteItemFromList(5);
        System.out.println(groceryItemDAO.getAllItemsGivenListId(6));
    }
}
