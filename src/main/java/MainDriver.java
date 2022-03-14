import controllers.GroceryListController;
import controllers.UserController;
import io.javalin.Javalin;
import models.GroceryItem;
import models.GroceryList;
import models.User;
import repositories.*;
import services.UserService;
import views.Landing;

import static io.javalin.apibuilder.ApiBuilder.*;

public class MainDriver {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImplement();
        GroceryListDAO groceryListDAO = new GroceryListDAOImplement();
        GroceryItemDAO groceryItemDAO = new GroceryItemDAOImplement();
        UserService userService = new UserService();

        //userDAO.createUser(new User("Trebolf", "password1", "Flo", "W"));
        //System.out.println(userDAO.getUserGivenUsername("Trebolf"));

        //groceryListDAO.createList(new GroceryList("Meijer",4));
        //System.out.println(groceryListDAO.getAllListsGivenUserId(4));

        //groceryItemDAO.createItemForListWithoutQuantity(new GroceryItem("Banana", null, 6));
        //groceryItemDAO.createItemForListWithQuantity(new GroceryItem("Grapes", 12, 6));

        //groceryItemDAO.markItemInCart(4);
        //groceryItemDAO.deleteItemFromList(5);
        //System.out.println(groceryItemDAO.getAllItemsGivenListId(6));

        //validate credentials
        //System.out.println(userService.validateCredentials("Trebolf", "password1"));

        //Landing.view();


        // JAVALIN
        Javalin app = Javalin.create().start(9001);

        UserController userController = new UserController();
        GroceryListController groceryListController = new GroceryListController();

        // :: method reference symbol
        //user path
        app.post("/user", userController::createUser);
        app.post("/login", userController::login);

        //list path
        app.get("/list/{userId}", groceryListController::displayAllListForUser);
        app.post("/list", groceryListController::createList);
        app.delete("/list/{listId}", groceryListController::deleteList);

        //APIBuilder, sugar syntax
        /*app.routes(() -> {
            path("list", () -> {
                get(groceryListController::displayAllListForUser);
                post(groceryListController::createList);
                path("{listid}", () -> {
                    delete(groceryListController::deleteList);
                });
            });
        });*/




    }
}
