package com.example.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
public class UserDetails {
    @Id
    private int userId;
    private String userName;
    private static int salary;

    /*@Id
    @Column(name = "roll")*/
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "NAME")
    public String getUserName() {
        return userName+" from getter";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static int getSalary() {
        return salary;
    }

    public static void setSalary(int salary) {
        UserDetails.salary = salary;
    }
}
