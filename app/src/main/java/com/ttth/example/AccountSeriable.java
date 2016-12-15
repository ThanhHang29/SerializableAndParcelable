package com.ttth.example;

import java.io.Serializable;

/**
 * Created by Thanh Hang on 15/12/16.
 */

public class AccountSeriable implements Serializable{
    private String user, pass;

    public AccountSeriable() {
    }

    public AccountSeriable(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "AccountSeriable{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
