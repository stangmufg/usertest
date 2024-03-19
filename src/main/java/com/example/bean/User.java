package com.example.bean;

public class User {
    private String userId;
    private String account;
    private Double balance;

    public User(String userId, String account, Double balance) {
        this.userId = userId;
        this.account = account;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
