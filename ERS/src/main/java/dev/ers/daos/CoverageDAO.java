package dev.ers.daos;

import dev.ers.entities.Coverage;
import dev.ers.entities.User;
import dev.ers.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoverageDAO implements GenericDAO<Coverage> {
    private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
    @Override
    public Coverage getById(int id) {
        return null;
    }

    @Override
    public List<Coverage> getAll() {
        List<Coverage> coverageslist = new ArrayList<>();
        String sql="select * from coverage";
        try(Connection conn=cu.getConnection()){
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while (rs.next()) {
                coverageslist.add(new Coverage(
                        rs.getInt("coverage_id"),
                        rs.getString("coverage_name"),
                        rs.getInt("coverage_percent")
                ));
            }
            return coverageslist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Coverage create(Coverage coverage) {
        return null;
    }

    @Override
    public void update(Coverage tUpdated) {

    }

    @Override
    public void delete(int id) {

    }
}
