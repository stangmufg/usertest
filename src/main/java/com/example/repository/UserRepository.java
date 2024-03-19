package com.example.repository;

import com.example.bean.User;

public interface UserRepository {
    public User fetchUser(String userId);

    public boolean updateBalance(String userId, double balance);
}
