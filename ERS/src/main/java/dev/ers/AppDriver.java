package dev.ers;

import dev.ers.controllers.AuthenticationController;
import dev.ers.controllers.CoverageController;
import dev.ers.controllers.ReimbursementController;
import dev.ers.controllers.UserController;

import dev.ers.daos.CoverageDAO;
import dev.ers.daos.ReimbursementDAO;
import dev.ers.daos.UserDAO;
import dev.ers.entities.Reimbursement;
import dev.ers.services.AuthenticationService;
import dev.ers.services.CoverageService;
import dev.ers.services.ReimbursementService;
import dev.ers.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;

public class AppDriver {
    public static void main(String[] args) {
        AuthenticationController ac =
                new AuthenticationController(
                        new AuthenticationService(new UserDAO()));
        CoverageController cc=new CoverageController(new CoverageService(new CoverageDAO()));
        UserController userController = new UserController(new UserService(new UserDAO()));
        ReimbursementController reimbursementController=new ReimbursementController(new ReimbursementService(new ReimbursementDAO()));
        Javalin app = Javalin.create(config -> {
                    config.enableCorsForAllOrigins();
                    config.addStaticFiles("/public", Location.CLASSPATH);
                }
        ).start(8080);
        app.routes(() -> {
            path("/authenticate",()->{
                post(ac.login);
            });
        path("/coverages", () -> {
                    get(cc::getAllCoverages);
                });
        path("/register",()->{
            post(userController.CreateUser);
        });
        path("/reimbursement",()->{
            post(reimbursementController.SubmitRequest);
        });
            path("/viewreimbursements/{id}",()->{
                get(reimbursementController::ViewReimbursements);
            });
            path("/viewallreimbursements",()->{
                get(reimbursementController::ViewAllReimbursements);
            });
            path("/viewpendingreimbursements",()->{
                get(reimbursementController::ViewpendingReimbursements);
            });
            path("/viewreimbursement/{id}",()->{
                get(reimbursementController::ViewReimbursement);
            });
            path("/updatereimbursement",()->{
                put(reimbursementController.UpdateReimbursement);
            });
            path("/updatereimbursementemployee",()->{
                put(reimbursementController.UpdateReimbursementEmployee);
            });
        });
    }
}
