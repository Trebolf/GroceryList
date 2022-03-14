package services;

import models.User;
import repositories.UserDAO;
import repositories.UserDAOImplement;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOImplement();
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User validateCredentials(String username, String password) {
        User user = this.userDAO.getUserGivenUsername(username);

        //username invalid
        if(user == null)
            return null;

        //password incorrect
        if(!password.equals(user.getPassword()))
            return null;

        return user;
    }

    public void createUser(User user) {
        this.userDAO.createUser(user);
    }
}
