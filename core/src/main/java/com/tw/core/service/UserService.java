package com.tw.core.service;

import com.tw.core.dao.hibernateDao.HibernateUserDao;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yzli on 7/8/15.
 */
@Service
public class UserService {

    //    private UserDao userDao = new UserDao();
//    private HibernateUserDao hibernateUserDao = new HibernateUserDao();
    @Autowired private HibernateUserDao hibernateUserDao;

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

    public boolean login(String name, String password){

        return  hibernateUserDao.login(name,password);
    }
}
