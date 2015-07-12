package com.tw.core.dao.hibernateDao;

import com.tw.core.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by yzli on 7/9/15.
 */

public class HibernateUserDao {

    public void insertUser(User user) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(user);
        session.getTransaction().commit();
//        HibernateUtil.getSessionFactory().close();
    }

    public void deleteUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = (User) session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
//        HibernateUtil.getSessionFactory().close();
    }

    public List<User> getUsers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");

        List<User> userList = query.list();
        session.getTransaction().commit();
//        HibernateUtil.getSessionFactory().close();使用单例时，只会query一次
//        session.close();

        return userList;
    }


    public void updateUser(User user) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.update(user);

        session.getTransaction().commit();
//        HibernateUtil.getSessionFactory().close();
    }

    public User getUserById(int id) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = (User) session.get(User.class, id);

        session.getTransaction().commit();
//        HibernateUtil.getSessionFactory().close();
        return user;
    }

}
