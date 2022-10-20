package dev.ers.controllers;

import dev.ers.services.CoverageService;

import io.javalin.http.Context;

public class CoverageController {
    private CoverageService coverageService;
    public CoverageController(CoverageService coveragesService){
        this.coverageService=coveragesService;
    }

    public void getAllCoverages(Context ctx){
        ctx.status(200);
        ctx.json(coverageService.getAllCoverages());
    }
}
