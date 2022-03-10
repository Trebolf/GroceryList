package repositories;

import models.User;

//define contract for functions
//in the case of the User interface, we need to get user id from username
//and create user with the parameters we constructed in the constructor.
public interface UserDAO {
    User getUserGivenUsername(String username);
    void createUser(User user);
}
