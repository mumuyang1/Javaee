package com.tw.core.dao.hibernateDao;

import com.tw.core.entity.User;
import com.tw.core.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yzli on 7/9/15.
 */
@Repository
public class HibernateUserDao {

    public void insertUser(User user) {

        user.setPassword(MD5Util.md5(user.getPassword()));
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(user);
        session.getTransaction().commit();
    }

    public void deleteUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = (User) session.load(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
    }

    public List<User> getUsers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Query query = session.createQuery("from User");

        List<User> userList = query.list();
        session.getTransaction().commit();

        return userList;
    }


    public void updateUser(User user) {

        user.setPassword(MD5Util.md5(user.getPassword()));
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.update(user);

        session.getTransaction().commit();
    }

    public User getUserById(int id) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User user = (User) session.get(User.class, id);

        session.getTransaction().commit();

        return user;
    }

    public boolean login (String name, String password){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("SELECT count(*) FROM User user where user.name = :name and user.password = :password");

        query.setParameter("name", name);
        query.setParameter("password", MD5Util.md5(password));

        Long count = (Long)query.uniqueResult();

        session.getTransaction().commit();

        return count != 0;
    }

    public static void main(String[] args){

        System.out.println(new HibernateUserDao().login("苏开","suka"));
    }
}
