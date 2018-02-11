package com.example.controller;

import com.example.conf.HibernateConfig;
import com.example.conf.HibernateConfigSingletone;
import com.example.domain.UserDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserApplication {
    public static void main(String[] args) {
        Transaction t = null;

        //configaration
            /*Configuration conf = new Configuration().configure("hibernate.cfg.xml");
            //conf.configure("src/main/resources/hibernate.cfg.xml");
            //conf.configure("main/resources/hibernate.cfg.xml");
            //creating seession factory object
            SessionFactory factory = conf.buildSessionFactory();
//            SessionFactory factory=new Configuration().configure().buildSessionFactory();
            System.out.println("properties====="+conf.getProperties());*/

        //Session session = HibernateConfig.getSessionFactory().openSession();
        Session session= HibernateConfigSingletone.getSessionFactoryInstance().openSession();


        //creating session object
//            Session session = factory.openSession();
        //

        try {

            /*UserDetails maa = new UserDetails();
            maa.setUserId(1);
            maa.setUserName("Jai Maa Durga");*/
            UserDetails user1 = new UserDetails();
            user1.setUserId(9);
            user1.setUserName("Second user9");
//            user1.setSalary(50000);


            //start a Transaction
            t = session.beginTransaction();
            //session.save(maa);
            session.save(user1);
            t.commit();
            System.out.println("first save======" + user1.getUserName());

            /****
             *  TODO Site: http://howtodoinjava.com/hibernate/save-and-saveorupdate-for-saving-hibernate-entities/
             */

//            Session sessionNew = HibernateConfig.getSessionFactory().openSession();
            Session sessionNew= HibernateConfigSingletone.getSessionFactoryInstance().openSession();
            t = sessionNew.beginTransaction();
            user1.setUserName("upadate name");
            sessionNew.saveOrUpdate(user1);
            System.out.println("second save======" + user1.getUserName());
            t.commit();

            /*UserDetails readuser = session.get(UserDetails.class, 5);
            if (readuser != null) {
                System.out.println(readuser.getUserId() + "==" + readuser.getUserName());
            }*/
            session.close();
            sessionNew.close();
            System.out.println("Data Saves Successfully");
        } catch (Exception e) {
            System.out.println("Exception occured" + e.getMessage());
            e.printStackTrace();
            t.rollback();
        }
    }
}
