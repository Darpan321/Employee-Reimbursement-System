package dev.ers.services;

import dev.ers.daos.UserDAO;
import dev.ers.entities.User;

import java.math.BigDecimal;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public User RegisterUser(User user){
        return userDAO.create(user);
    }
}
