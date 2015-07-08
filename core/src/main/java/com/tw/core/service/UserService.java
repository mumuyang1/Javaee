package com.tw.core.service;

import com.tw.core.dao.UserDao;

import java.sql.SQLException;

/**
 * Created by yzli on 7/8/15.
 */
public class UserService {

    public void deleteUserBy(int id) throws SQLException {

        UserDao userDao = new UserDao();
        userDao.deleteUser(id);
    }
}
