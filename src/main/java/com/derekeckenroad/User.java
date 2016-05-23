package com.derekeckenroad;

import java.util.ArrayList;

public class User {

    private String userName;
    private String password;

    public ArrayList<Account> accountList = new ArrayList<Account>();

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setPassword(String newPassword){
        password = newPassword;
    }

    public void setUserName(String newUserName){
        userName = newUserName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
