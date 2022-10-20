package dev.ers.daos;

import dev.ers.entities.Coverage;
import dev.ers.entities.Reimbursement;
import dev.ers.entities.User;
import dev.ers.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAO implements GenericDAO<Reimbursement>{
    private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Reimbursement getById(int id) {
        String sql="select r.reimbursement_id,u.first_name ,r.\"date\" ,r.\"time\" ,r.\"location\" ,r.description ,r.\"cost\",u.available_reimbursement,u.user_id ," +
                "r.grading_format,c.coverage_id,c.coverage_name ,c.coverage_percent ,r.any_justification ,\n" +
                "r.optional_files ,r.current_status,r.reason  from reimbursement r join users u on r.user_id =u.user_id join coverage c on r.coverage_id =c.coverage_id where r.reimbursement_id=?; ";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            if (rs.next()) {
                User user=new User(
                        rs.getString("first_name"),
                        rs.getBigDecimal("available_reimbursement"),
                        rs.getInt("user_id")
                );
                Coverage coverage=new Coverage(
                        rs.getInt("coverage_id"),
                        rs.getString("coverage_name"),
                        rs.getInt("coverage_percent")
                );
                Reimbursement reimbursement=new Reimbursement(
                        rs.getInt("reimbursement_id"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("location"),
                        rs.getString("description"),
                        rs.getDouble("cost"),
                        rs.getString("grading_format"),
                        rs.getString("any_justification"),
                        rs.getString("optional_files"),
                        rs.getString("current_status"),
                        rs.getString("reason"),
                        coverage,
                        user
                );
                return reimbursement;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Reimbursement> getAll() {
        List<Reimbursement> reimbursementlist = new ArrayList<>();
        String sql="select * from reimbursement  order by date;";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                reimbursementlist.add(new Reimbursement(
                        rs.getInt("reimbursement_id"),
                        rs.getInt("user_id"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("description"),
                        rs.getString("current_status")
                ));
            }
            return reimbursementlist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Reimbursement> getAllpending() {
        List<Reimbursement> reimbursementlist = new ArrayList<>();
        String sql="select * from reimbursement where current_status='submitted' order by date";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                reimbursementlist.add(new Reimbursement(
                        rs.getInt("reimbursement_id"),
                        rs.getInt("user_id"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("description"),
                        rs.getString("current_status")
                ));
            }
            return reimbursementlist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Reimbursement> getAll(int id) {
        List<Reimbursement> reimbursementlist = new ArrayList<>();
        String sql="select * from reimbursement where user_id=?;";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                reimbursementlist.add(new Reimbursement(
                        rs.getInt("reimbursement_id"),
                        rs.getInt("user_id"),
                        rs.getString("date"),
                        rs.getString("time"),
                        rs.getString("description"),
                        rs.getString("current_status")
                ));
            }
            return reimbursementlist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Reimbursement create(Reimbursement reimbursement) {
        String sql="insert into reimbursement values(default,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, reimbursement.getUserid());
            ps.setString(2, reimbursement.getDate());
            ps.setString(3, reimbursement.getTime());
            ps.setString(4, reimbursement.getLocation());
            ps.setString(5, reimbursement.getDescription());
            ps.setDouble(6, reimbursement.getCost());
            ps.setString(7,reimbursement.getGradingformat());
            ps.setInt(8, reimbursement.getCoverageid());
            ps.setString(9, reimbursement.getAnyjustification());
            ps.setString(10,reimbursement.getOptionalfiles());
            ps.setString(11,reimbursement.getCurrentstatus());
            ps.setString(12,reimbursement.getCreatedon());
            ps.setString(13,reimbursement.getUpdatedon());
            ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Reimbursement tUpdated) {
        String sql="update reimbursement set current_status=?,reason=?,updated_on=? where reimbursement_id=?;update users set available_reimbursement=? where user_id=? ";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, tUpdated.getCurrentstatus());
            ps.setString(2, tUpdated.getReason());
            ps.setString(3,tUpdated.getUpdatedon());
            ps.setInt(4, tUpdated.getReimbursementid());
            ps.setBigDecimal(5,tUpdated.getAvailableReimbursement());
            ps.setInt(6,tUpdated.getUserid());
            ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void updatereimbursement(Reimbursement tUpdated) {
        String sql="update reimbursement set date=?,time=?,location=?,description=?,cost=?,grading_format=?,coverage_id=?,any_justification=?,optional_files=?,current_status=?,created_on=?,updated_on=?  where user_id=? and reimbursement_id=? ";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, tUpdated.getDate());
            ps.setString(2, tUpdated.getTime());
            ps.setString(3, tUpdated.getLocation());
            ps.setString(4, tUpdated.getDescription());
            ps.setDouble(5, tUpdated.getCost());
            ps.setString(6,tUpdated.getGradingformat());
            ps.setInt(7, tUpdated.getCoverageid());
            ps.setString(8, tUpdated.getAnyjustification());
            ps.setString(9,tUpdated.getOptionalfiles());
            ps.setString(10,tUpdated.getCurrentstatus());
            ps.setString(11,tUpdated.getCreatedon());
            ps.setString(12,tUpdated.getUpdatedon());
            ps.setInt(13, tUpdated.getUserid());
            ps.setInt(14, tUpdated.getReimbursementid());
            ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }
}
