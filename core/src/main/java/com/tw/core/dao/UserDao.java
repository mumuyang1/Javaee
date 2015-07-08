package com.tw.core.dao;

import com.tw.core.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        return usersList;
    }

    public Boolean deleteUser(int id) throws SQLException {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "DELETE *FROM user WHERE id = 'id'";

        Statement st = connection.createStatement();
        boolean rs = st.execute(sql);
        return rs;
    }
}
