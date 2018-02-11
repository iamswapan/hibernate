package com.example.domain;



import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.util.Date;

@Entity (name = "OTHER_USER")
public class User{
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    public int userId;
    @Column(name = "USER_NAME")
    public String userName;
//    private static int salary;

    @Column(name = "DOJ", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date doj;

    @Column(name = "ADDRESS")
    @Type(type = "text")
    @Transient
    private String Address;

    public User(){}

    //    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    @Column(name = "NAME")
    public String getUserName() {
        return userName + " from getter method";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /*public static int getSalary() {
        return salary;
    }

    public static void setSalary(int salary) {
        UserDetails.salary = salary;
    }*/


    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
