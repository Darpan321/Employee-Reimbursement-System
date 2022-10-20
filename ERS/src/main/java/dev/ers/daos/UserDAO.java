package dev.ers.daos;

import dev.ers.entities.User;
import dev.ers.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements  GenericDAO<User> {
    private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public User getUserByUsername(String username){
        String sql="select * from users where emailid=?";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("emailid"),
                        rs.getBigDecimal("available_reimbursement"),
                        rs.getString("role"),
                        rs.getString("password")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User create(User user) {
        String sql="insert into users values(default,?,?,?,?,?,?)";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmailId());
            ps.setBigDecimal(4,user.getAvailableReimbursement());
            ps.setString(5, user.getRole());
            ps.setString(6, user.getPassword());
            ps.executeQuery();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User tUpdated) {

    }

    @Override
    public void delete(int id) {

    }
}
