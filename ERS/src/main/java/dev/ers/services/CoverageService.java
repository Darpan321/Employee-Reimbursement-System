package dev.ers.services;

import dev.ers.daos.CoverageDAO;
import dev.ers.daos.UserDAO;
import dev.ers.entities.Coverage;

import java.util.List;

public class CoverageService {
    private CoverageDAO coverageDAO;
    public CoverageService(CoverageDAO coverageDAO){
        this.coverageDAO=coverageDAO;
    }
    public List<Coverage> getAllCoverages(){
        return coverageDAO.getAll();
    }
}
