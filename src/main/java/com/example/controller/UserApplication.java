package com.example.controller;

import com.example.conf.HibernateConfig;
import com.example.domain.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UserApplication {
    public static void main(String[] args) {
        Transaction t=null;
        try {

            //configaration
            /*Configuration conf = new Configuration().configure("hibernate.cfg.xml");
            //conf.configure("src/main/resources/hibernate.cfg.xml");
            //conf.configure("main/resources/hibernate.cfg.xml");
            //creating seession factory object
            SessionFactory factory = conf.buildSessionFactory();
//            SessionFactory factory=new Configuration().configure().buildSessionFactory();
            System.out.println("properties====="+conf.getProperties());*/

            Session session= HibernateConfig.getSessionFactory().openSession();

            //creating session object
//            Session session = factory.openSession();
            //

            /*UserDetails maa = new UserDetails();
            maa.setUserId(1);
            maa.setUserName("Jai Maa Durga");*/
            UserDetails user1=new UserDetails();
            //user1.setUserId(5);
            user1.setUserName("Second user");
            user1.setSalary(50000);


            //start a Transaction
            t=session.beginTransaction();
            //session.save(maa);
            session.save(user1);
            t.commit();
            UserDetails readuser=session.get(UserDetails.class, 5);
            if(readuser!=null){
                System.out.println(readuser.getUserId()+"=="+readuser.getUserName());
            }
            session.close();
            System.out.println("Data Saves Successfully");
        }catch (Exception e){
            System.out.println("Exception occured"+e.getMessage());
            t.rollback();
        }
    }
}
