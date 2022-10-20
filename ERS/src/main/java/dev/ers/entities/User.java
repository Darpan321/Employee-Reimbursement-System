package dev.ers.entities;

import java.math.BigDecimal;

public class User {
    private int UserId;
    private String FirstName;
    private String LastName;
    private String EmailId;
    private BigDecimal AvailableReimbursement;
    private String Role;
    private String Password;

    public User(){

    }
    public User(int userId,String firstName,String lastName,String emailId,BigDecimal availableReimbursement,String role,String password){
        this.UserId=userId;
        this.FirstName=firstName;
        this.LastName=lastName;
        this.EmailId=emailId;
        this.AvailableReimbursement=availableReimbursement;
        this.Role=role;
        this.Password=password;
    }
    public User(String firstName,BigDecimal availableReimbursement,int userId){
        this.FirstName=firstName;
        this.AvailableReimbursement=availableReimbursement;
        this.UserId=userId;
    }
    //Above are the get methods
    public int getUserId(){
        return UserId;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getEmailId(){
        return EmailId;
    }
    public BigDecimal getAvailableReimbursement(){
        return AvailableReimbursement;
    }
    public String getRole(){
        return Role;
    }
    public String getPassword(){
        return Password;
    }
    //Above are the set methods
    public void setUserId(int userid){
        this.UserId=userid;
    }
    public void setFirstName(String firstname){
        this.FirstName=firstname;
    }
    public void setLastName(String lastname){
        this.LastName=lastname;
    }
    public void setEmailId(String emailid){
        this.EmailId=emailid;
    }
    public void setRole(String role){
        this.Role=role;
    }
    public void setAvailableReimbursement(BigDecimal availablereimbursement){
        this.AvailableReimbursement=availablereimbursement;
    }
    public void setPassword(String password){
        this.Password=password;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", EmailId='" + EmailId + '\'' +
                ", AvailableReimbursement=" + AvailableReimbursement +
                ", Role='" + Role + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
