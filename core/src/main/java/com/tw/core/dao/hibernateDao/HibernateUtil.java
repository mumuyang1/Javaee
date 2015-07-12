package com.tw.core.dao.hibernateDao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by yzli on 7/9/15.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory ;
    static {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    public static SessionFactory getSessionFactory() {
//        //读取hibernate.cfg.xml文件
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
//                applySettings(configuration.getProperties());
//        SessionFactory factory = configuration.buildSessionFactory(builder.build());
//
//        return factory;
//    }
}
