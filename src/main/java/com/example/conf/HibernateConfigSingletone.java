package com.example.conf;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Objects;

/**
 * Created by ttnd on 7/12/17.
 */

public class HibernateConfigSingletone {
    private static SessionFactory factory;

    public HibernateConfigSingletone() {
    }

    public static SessionFactory getSessionFactoryInstance() {
        if (Objects.isNull(factory)) {
            Configuration conf = new Configuration().configure();
            return conf.buildSessionFactory();
        }
        return factory;
    }
}
