package dev.ers.entities;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Optional;

public class Reimbursement {
    private int reimbursementid;
    private int userid;
    private String date;
    private String time;
    private String location;
    private String description;
    private Double cost;
    private String gradingformat;
    private int coverageid;
    private String anyjustification;
    private String optionalfiles;
    private String currentstatus;
    private String createdon;
    private String updatedon;
    private User user;
    private Coverage coverage;
    private String reason;
    private BigDecimal availableReimbursement;
    public Reimbursement(){}
    public Reimbursement(int reimbursementid,int userid,String date,String time,String location,String description,Double cost,String gradingformat,
                         int coverageid,String anyjustification,String optionalfiles,String currentstatus,String createdon,String updatedon){
        this.reimbursementid=reimbursementid;
        this.userid=userid;
        this.date=date;
        this.time=time;
        this.location=location;
        this.description=description;
        this.cost=cost;
        this.gradingformat=gradingformat;
        this.coverageid=coverageid;
        this.anyjustification=anyjustification;
        this.optionalfiles=optionalfiles;
        this.currentstatus=currentstatus;
        this.createdon=createdon;
        this.updatedon=updatedon;
    }
    public Reimbursement(String date,String time,String location,String description,Double cost,String gradingformat,
                         int coverageid,String anyjustification,String optionalfiles,String currentstatus,String createdon,String updatedon,int userid,int reimbursementid){
        this.date=date;
        this.time=time;
        this.location=location;
        this.description=description;
        this.cost=cost;
        this.gradingformat=gradingformat;
        this.coverageid=coverageid;
        this.anyjustification=anyjustification;
        this.optionalfiles=optionalfiles;
        this.currentstatus=currentstatus;
        this.createdon=createdon;
        this.updatedon=updatedon;
        this.userid=userid;
        this.reimbursementid=reimbursementid;
    }
    public Reimbursement(int reimbursementid,String date,String time,String location,String description,Double cost,String gradingformat,String anyjustification,
                         String optionalfiles,String currentstatus,String reason,Coverage coverage,User user){
        this.reimbursementid=reimbursementid;
        this.date=date;
        this.time=time;
        this.location=location;
        this.description=description;
        this.cost=cost;
        this.gradingformat=gradingformat;
        this.anyjustification=anyjustification;
        this.optionalfiles=optionalfiles;
        this.currentstatus=currentstatus;
        this.reason=reason;
        this.user=user;
        this.coverage=coverage;
    }
    public Reimbursement(int reimbursementid,int userid,String date, String time, String description, String currentstatus){
        this.reimbursementid=reimbursementid;
        this.userid=userid;
        this.date=date;
        this.time=time;
        this.description=description;
        this.currentstatus=currentstatus;
    }
    public Reimbursement(String currentstatus, String reason, String updatedon, int reimbursementid, BigDecimal availableReimbursement,int userid){

        this.currentstatus=currentstatus;
        this.reason=reason;
        this.updatedon=updatedon;
        this.reimbursementid=reimbursementid;
        this.availableReimbursement=availableReimbursement;
        this.userid=userid;
    }

    public BigDecimal getAvailableReimbursement() {
        return availableReimbursement;
    }

    public void setAvailableReimbursement(BigDecimal availableReimbursement) {
        this.availableReimbursement = availableReimbursement;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }

    public int getReimbursementid() {
        return reimbursementid;
    }

    public void setReimbursementid(int reimbursementid) {
        this.reimbursementid = reimbursementid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getGradingformat() {
        return gradingformat;
    }

    public void setGradingformat(String gradingformat) {
        this.gradingformat = gradingformat;
    }

    public int getCoverageid() {
        return coverageid;
    }

    public void setCoverageid(int coverageid) {
        this.coverageid = coverageid;
    }

    public String getAnyjustification() {
        return anyjustification;
    }

    public void setAnyjustification(String anyjustification) {
        this.anyjustification = anyjustification;
    }

    public String getOptionalfiles() {
        return optionalfiles;
    }

    public void setOptionalfiles(String optionalfiles) {
        this.optionalfiles = optionalfiles;
    }

    public String getCurrentstatus() {
        return currentstatus;
    }

    public void setCurrentstatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    public String getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(String updatedon) {
        this.updatedon = updatedon;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementid=" + reimbursementid +
                ", userid=" + userid +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", gradingformat='" + gradingformat + '\'' +
                ", coverageid=" + coverageid +
                ", anyjustification='" + anyjustification + '\'' +
                ", optionalfiles='" + optionalfiles + '\'' +
                ", currentstatus='" + currentstatus + '\'' +
                ", createdon='" + createdon + '\'' +
                ", updatedon='" + updatedon + '\'' +
                ", user=" + user +
                ", coverage=" + coverage +
                ", reason='" + reason + '\'' +
                ", availableReimbursement=" + availableReimbursement +
                '}';
    }
}
