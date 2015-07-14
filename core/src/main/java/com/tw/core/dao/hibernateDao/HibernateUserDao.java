package com.tw.core.dao.hibernateDao;

import com.tw.core.entity.User;
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
        query.setParameter("password", password);

        Long count = (Long)query.uniqueResult();

        System.out.println(count);

        if (count == 0){
            return false;
        }
        session.getTransaction().commit();

        return  true;
    }

    public static void main(String[] args){

        System.out.println(new HibernateUserDao().login("薛倩","123456"));
    }

}
