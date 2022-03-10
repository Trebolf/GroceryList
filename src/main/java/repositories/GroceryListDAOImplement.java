package repositories;

import models.GroceryList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroceryListDAOImplement implements GroceryListDAO{
    String url = "jdbc:postgresql://fvw-fsj-db.crqc96fa2ogt.us-east-1.rds.amazonaws.com/GroceryList-Project";
    String username = "postgres";
    String password = "p4ssw0rd";

    @Override
    public List<GroceryList> getAllListsGivenUserId(Integer userId) {
        List<GroceryList> lists = new ArrayList<>();

        try {
            //1. CONNECT
            //2. PREPARE
            //3. EXECUTE
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            String sql = "select * from list_table where user_id_fk = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lists.add(new GroceryList(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3))
                        );
            }

        } catch (SQLException sqle) {
        sqle.printStackTrace();
    }
        return lists;
    }

    @Override
    public void createList(GroceryList groceryList) {
        try {
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            String sql = "insert into list_table (list_name, user_id_fk)\n" +
                    "\tvalues (?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, groceryList.getName());
            ps.setInt(2, groceryList.getUserId());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Override
    public void deleteList(GroceryList groceryList) {
        try {
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            String sql = "delete from list_table where list_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2, groceryList.getUserId());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
