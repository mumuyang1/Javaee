package com.tw.core.dao;

import com.tw.core.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yzli on 7/7/15.
 */
public class UserDao {

    public List<User> getUsers(){

        List<User> usersList = new ArrayList<User>();

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "SELECT * FROM users";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                User user = new User(new Integer(rs.getString("id")),rs.getString("name"), rs.getNString("gender"), rs.getNString("mailbox"), rs.getInt("age"));
                usersList.add(user);
            }
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;
    }

    public void deleteUser(int id) throws SQLException {

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "delete from users where id = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, id);
        int rows = st.executeUpdate();

        if(rows > 0) {
            System.out.println("delete successfully!!");
        }
        st.close();
        connection.close();
    }

    public void insertUser(User user){
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
            if(rows > 0) {
                System.out.println("operate successfully!");
            }
            sta.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

//    public static void main(String[] args) throws SQLException {
//        new UserDao().deleteUser(1);
//    }
}
