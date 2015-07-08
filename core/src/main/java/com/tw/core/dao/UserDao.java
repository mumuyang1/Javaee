package com.tw.core.dao;

import com.tw.core.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzli on 7/7/15.
 */
public class UserDao {

    public List<User> getUsers() throws SQLException {

        List<User> usersList = new ArrayList<User>();

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "SELECT * FROM user";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);


        while (rs.next()) {

            User user = new User(rs.getInt("id"), rs.getString("name"), rs.getNString("gender"), rs.getNString("email"), rs.getInt("age"));
            usersList.add(user);
        }

        st.close();
        connection.close();
        return usersList;
    }

    public void deleteUser(int id) throws SQLException {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "delete from user where id=?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, id);
        int rows = st.executeUpdate();
        if(rows > 0) {
            System.out.println("delete successfully!!");
        }
        st.close();
        connection.close();
    }
    

    public static void main(String[] args) throws SQLException {
        new UserDao().deleteUser(1);
    }
}
