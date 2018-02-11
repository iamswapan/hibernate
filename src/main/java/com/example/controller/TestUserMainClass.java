package com.example.controller;

import com.example.conf.HibernateConfigSingletone;
import com.example.domain.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.Date;


/**
 * Created by ttnd on 6/12/17.
 */
public class TestUserMainClass {
    public static void main(String[] args) {
        Session session = HibernateConfigSingletone.getSessionFactoryInstance().openSession();
//        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user1 = new User();
            //user1.setUserId(3);
            user1.setUserName("First User");
            //user1.setSalary(5);
            user1.setDoj(new Date());
            user1.setAddress("Address 1");

            session.save(user1);

            User user2 = new User();
            //user1.setUserId(3);
            user2.setUserName("Second User");
            //user1.setSalary(5);
            user2.setDoj(new Date());
            user2.setAddress("Address 2");
            session.save(user2);

            transaction.commit();
        }catch (Exception ex){
            System.out.println("Exception occurred "+ex.getMessage());
            ex.printStackTrace();;
            transaction.rollback();
        }

    }
}
