package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private int userId;
    @Column(name = "USER_NAME")
    private String userName;
//    private static int salary;

    //    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //@Column(name = "NAME")
    public String getUserName() {
        return userName + " from getter";
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
}
