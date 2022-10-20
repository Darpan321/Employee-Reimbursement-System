package dev.ers.services;

import dev.ers.daos.UserDAO;
import dev.ers.entities.User;

public class AuthenticationService {
    private UserDAO userDAO;
    public AuthenticationService(UserDAO userDAO){
        this.userDAO=userDAO;
    }
    public User login(String Username,String password){
        User u=userDAO.getUserByUsername(Username);
        if(u.getPassword().equals(password)){
            return u;
        }else{
            System.out.println("Password Dont Match");
            return null;
        }
    }
}
