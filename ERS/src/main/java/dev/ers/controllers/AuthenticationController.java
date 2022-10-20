package dev.ers.controllers;

import dev.ers.entities.User;
import dev.ers.services.AuthenticationService;
import io.javalin.http.Handler;

public class AuthenticationController {
    private AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService=authenticationService;
    }

    public Handler login = ctx -> {
        // Author a =  ctx.bodyAsClass(Author.class);
        User u = ctx.bodyAsClass(User.class); // Jackson Library is mapping all fields from the JSON to our Author Class

        User authenticatedUser = authenticationService.login(u.getEmailId(), u.getPassword());
        if (authenticatedUser != null) {
            ctx.status(200);
            ctx.json(authenticatedUser);
        }else{
            ctx.status(201);
        }
    };
}
