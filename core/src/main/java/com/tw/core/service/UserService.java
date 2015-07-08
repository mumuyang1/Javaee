package com.tw.core.service;

import com.tw.core.dao.UserDao;
import com.tw.core.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yzli on 7/8/15.
 */
public class UserService {

    public List<User> getUsers() {

        return new UserDao().getUsers();
    }

    public void deleteUserBy(int id) throws SQLException {

        UserDao userDao = new UserDao();
        userDao.deleteUser(id);
    }
}
