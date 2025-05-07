package com.chaitanya.csc_center.controller;

import com.chaitanya.csc_center.model.User;
import com.chaitanya.csc_center.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User validUser = userService.loginUser(user.getName(), user.getPassword());
        return (validUser != null) ? "Login Successful" : "Invalid credentials";
    }
}
