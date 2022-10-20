package dev.ers.controllers;

import dev.ers.entities.Reimbursement;
import dev.ers.entities.User;
import dev.ers.services.CoverageService;
import dev.ers.services.ReimbursementService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ReimbursementController {
    private ReimbursementService reimbursementService;
    public ReimbursementController(ReimbursementService reimbursementService){
        this.reimbursementService=reimbursementService;
    }
    public Handler SubmitRequest = ctx -> {
        Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class); // Jackson Library is mapping all fields from the JSON to our Author Class

        Reimbursement request=reimbursementService.SubmitRequest(reimbursement);
        ctx.status(200);
    };
    public void ViewReimbursements (Context ctx){
        ctx.status(200);
        int userid = Integer.parseInt(ctx.pathParam("id"));
        ctx.json(reimbursementService.ViewReimbursements(userid));
    }
    public void ViewReimbursement (Context ctx){
        ctx.status(200);
        int reimbursementid = Integer.parseInt(ctx.pathParam("id"));
        ctx.json(reimbursementService.ViewReimbursement(reimbursementid));
    }
    public void ViewAllReimbursements(Context ctx){
        ctx.status(200);
        ctx.json(reimbursementService.ViewAllReimbursements());
    }
    public void ViewpendingReimbursements(Context ctx){
        ctx.status(200);
        ctx.json(reimbursementService.ViewpendingReimbursements());
    }

    public Handler UpdateReimbursement  = ctx -> {
        Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class); // Jackson Library is mapping all fields from the JSON to our Author Class

        Reimbursement request=reimbursementService.UpdateRequest(reimbursement);
        ctx.status(200);
    };
    public Handler UpdateReimbursementEmployee  = ctx -> {
        Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class); // Jackson Library is mapping all fields from the JSON to our Author Class

        Reimbursement request=reimbursementService.UpdateRequestEmployee(reimbursement);
        ctx.status(200);
    };
}
