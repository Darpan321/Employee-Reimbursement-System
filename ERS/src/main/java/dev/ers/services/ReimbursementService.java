package dev.ers.services;

import dev.ers.daos.ReimbursementDAO;
import dev.ers.entities.Coverage;
import dev.ers.entities.Reimbursement;

import java.util.List;

public class ReimbursementService {
    private ReimbursementDAO reimbursementDAO;
    public ReimbursementService(ReimbursementDAO reimbursementDAO){
        this.reimbursementDAO=reimbursementDAO;
    }
    public Reimbursement SubmitRequest(Reimbursement reimbursement){
        return reimbursementDAO.create(reimbursement);
    }
    public Reimbursement UpdateRequest(Reimbursement reimbursement){
         reimbursementDAO.update(reimbursement);
         return null;
    }
    public Reimbursement UpdateRequestEmployee(Reimbursement reimbursement){
        reimbursementDAO.updatereimbursement(reimbursement);
        return null;
    }
    public List<Reimbursement> ViewReimbursements(int id){

        return reimbursementDAO.getAll(id);
    }
    public Reimbursement ViewReimbursement(int id){

        return reimbursementDAO.getById(id);
    }
    public List<Reimbursement> ViewAllReimbursements(){
        return reimbursementDAO.getAll();
    }
    public List<Reimbursement> ViewpendingReimbursements(){
        return reimbursementDAO.getAllpending();
    }

}
