package com.tw.core.dao;

import com.tw.core.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzli on 7/7/15.
 */
public class UserDao {

    private DBConnection dbConnection = new DBConnection();

    public List<User> getUsers() {

        List<User> usersList = new ArrayList<User>();

        Connection connection = dbConnection.getConnection();

        String sql = "SELECT * FROM users";
        Statement st = null;

        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                User user = new User(new Integer(rs.getString("id")), rs.getString("name"), rs.getNString("gender"), rs.getNString("mailbox"), rs.getInt("age"));
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                st.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usersList;
    }

    public User getUserById(int id) {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        User user = new User();

        String sql = "SELECT * FROM users WHERE id = ? ";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {

                user = new User(new Integer(rs.getString("id")), rs.getString("name"), rs.getNString("gender"), rs.getNString("mailbox"), rs.getInt("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }


    public void deleteUser(int id) {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "delete from users where id = ?";
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(sql);
            st.setInt(1, id);
            int rows = st.executeUpdate();

            if (rows > 0) {
                System.out.println("delete successfully!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                st.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void insertUser(User user) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "insert into users(id,name,gender,mailbox,age) values(?,?,?,?,?)";
        PreparedStatement sta = null;
        try {
            sta = connection.prepareStatement(sql);
            sta.setString(1, null);
            sta.setString(2, user.getName());
            sta.setString(3, user.getGender());
            sta.setString(4, user.getMailbox());
            sta.setInt(5, user.getAge());
            int rows = sta.executeUpdate();
            if (rows > 0) {
                System.out.println("operate successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                sta.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void updateUser(User user) {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("UPDATE users SET name=?,gender=?,mailbox=?,age=? WHERE id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setString(3, user.getMailbox());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setInt(5, user.getUserId());
            int row = preparedStatement.executeUpdate();
            System.out.print(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
