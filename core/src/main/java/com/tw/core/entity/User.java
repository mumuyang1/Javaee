package com.tw.core.entity;

/**
 * Created by yzli on 7/7/15.
 */
public class User {

    private int userId;
    private String name;
    private String gender;
    private String mailbox;
    private int age;
    private String password;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int userId, String name, String gender, String mailbox, int age, String password) {
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.mailbox = mailbox;
        this.age = age;
        this.password = password;
    }

    public User(String name, String gender, String mailbox, int age, String password) {
        this.name = name;
        this.gender = gender;
        this.mailbox = mailbox;
        this.age = age;
        this.password = password;
    }
}
