package com.example.conf;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by swapan on 25/8/17.
 */
public class HibernateConfig {
    public static Configuration configure(){
        return new Configuration().configure();
    }

    public static SessionFactory getSessionFactory(){
        return configure().buildSessionFactory();
    }
}
