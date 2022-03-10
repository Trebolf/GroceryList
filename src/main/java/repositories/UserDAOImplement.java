package repositories;

import models.User;

import java.sql.*;

//create a class that implements the DAO, right-click implement methods.
////////    CONNECT POSTGRESQL DATABASE ON AWS USING JDBC??
//          - endpoint (url)
//              + syntax: jdbc:postgresql:// [ENDPOINT] / [DATABASE_NAME]
//          - username for our AWS database
//          - password for our AWS database
//          - driver (the download that popped up when we created our connection for the first time).
//              + add to pom.xml as dependency.

// What is JDBC?
//  - Java Database Connectivity
//      + Allows us to connect to a database and run sql commands

// Interfaces and classed of JDBC:
//  - Connection (interface) = active connection with the database
//  - DriverManager : retrieves the connection from our database
//  - Statement: Object representation of th sql statement (does not prevent sql injection)
//      + PreparedStatement (what we use): object representation of the sql statement
//          -  (prevents SQL injection)

// Most common errors connecting to JDBC:
//  No Suitable driver found: No driver or the URL string is incorrect.

public class UserDAOImplement implements UserDAO{
    String url = "jdbc:postgresql://fvw-fsj-db.crqc96fa2ogt.us-east-1.rds.amazonaws.com/GroceryList-Project";
    String username = "postgres";
    String password = "p4ssw0rd";

    @Override
    public User getUserGivenUsername(String username) {
        User user = null;

        try {
            //retrieve active connection from our database
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            String sql = "select * from user_table where user_username = ?;";

            //preparing our sql statement
            PreparedStatement ps = conn.prepareStatement(sql);

            //we are adding the username into the question mark in the sql statement
            //parameter index will find the first index where the "?" occurs and replaces it.
            ps.setString(1, username);

            //results will be stored in object "rs"
            //DQL FOR RESULTS USE QUERY
            ResultSet rs = ps.executeQuery();

            //while loop needed to print
            while(rs.next()) {
                user = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getTimestamp(6)
                        );
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return user;
    }

    @Override
    public void createUser(User user) {

        try{
            Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
            String sql = "insert into user_table (user_username, user_password, user_firstname, user_lastname) values (?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());

            //DML STATEMENTS USE UPDATE
            ps.executeUpdate();

        } catch(SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
