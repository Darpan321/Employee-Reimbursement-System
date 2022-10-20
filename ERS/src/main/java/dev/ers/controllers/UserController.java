package dev.ers.controllers;

import dev.ers.entities.User;
import dev.ers.services.UserService;
import io.javalin.http.Handler;

import javax.naming.Context;

public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }
    public Handler CreateUser = ctx -> {
        // Author a =  ctx.bodyAsClass(Author.class);
        User u = ctx.bodyAsClass(User.class); // Jackson Library is mapping all fields from the JSON to our Author Class

        User CreateUser = userService.RegisterUser(u);
        ctx.status(200);
    };
}
