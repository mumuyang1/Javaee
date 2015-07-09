package com.tw.core.service;

import com.tw.core.dao.hibernateDao.HibernateUserDao;
import com.tw.core.entity.User;

import java.util.List;

/**
 * Created by yzli on 7/8/15.
 */
public class UserService {

    //    private UserDao userDao = new UserDao();
    private HibernateUserDao hibernateUserDao = new HibernateUserDao();

    public List<User> getUsers() {

        return hibernateUserDao.getUsers();
    }

    public void deleteUserBy(int id) {

        hibernateUserDao.deleteUserById(id);
    }

    public void insertUser(User user) {

        hibernateUserDao.insertUser(user);
    }

    public void updateUser(User user) {

        hibernateUserDao.updateUser(user);
    }

    public User getUserBy(int id) {

        return hibernateUserDao.getUserById(id);
    }
}
