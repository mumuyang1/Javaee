package com.tw.core.service;

import com.tw.core.dao.UserDao;
import com.tw.core.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yzli on 7/8/15.
 */
public class UserService {

    private UserDao userDao = new UserDao();

    public List<User> getUsers() {

        return userDao.getUsers();
    }

    public void deleteUserBy(int id) throws SQLException {

        userDao.deleteUser(id);
    }

    public void insertUser(User user){

        userDao.insertUser(user);
    }

    public void updateUser(User user){

        userDao.updateUser(user);
    }

    public User getUserBy(int id){

        return userDao.getUserById(id);
    }
}
