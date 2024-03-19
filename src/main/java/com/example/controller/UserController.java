package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.service.UserService;

@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{userId}")
    public User getUser(@PathVariable String userId) {
        User user = userService.fetchUser(userId);

        return user;
    }

    @GetMapping(value = "/deposit/{userId}")
    public String deposit(@PathVariable String userId, @RequestParam Double depositAmount) {
        boolean result = userService.deposit(userId, depositAmount);

        return result ? "SUCCESSFUL" : "FAIL";
    }
}
