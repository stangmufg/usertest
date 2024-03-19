package com.example.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    private User userUnderProcessing;
    private Random random = new Random();

    public User fetchUser(String userId) {
        // retrieve from backend
        mimicRandomProcessingTime(100);
        User user = repository.fetchUser(userId);

        return user;
    }

    public boolean deposit(String userId, double amount) {

        System.out.println(getTimeString() + "UserService.deposit() called");

        // retrieve from backend
        mimicRandomProcessingTime(100);
        userUnderProcessing = repository.fetchUser(userId);

        // processing
        // mimicRandomProcessingTime(5000);
        double newBalance = calculateNewBalance(amount);

        // save to backend
        mimicRandomProcessingTime(100);
        boolean result = this.repository.updateBalance(userId, newBalance);

        return result;
    }

    // mimicking a very complicated process needed to be separated into another
    // function
    private double calculateNewBalance(double amount) {

        String accountType = userUnderProcessing.getAccount();
        if (accountType.equals("Saving")) {
            // Saving account need some complex calculation
            mimicRandomProcessingTime(10000);
        } else {
            mimicRandomProcessingTime(200);
        }
        double currentBalance = this.userUnderProcessing.getBalance();
        double newBalance = currentBalance + amount;

        return newBalance;
    }

    private String getTimeString() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public void mimicRandomProcessingTime(int time) {
        try {
            // mimic processing time
            Thread.sleep(random.nextInt(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
