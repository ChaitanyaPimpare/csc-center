package com.chaitanya.csc_center.controller;

import com.chaitanya.csc_center.model.User;

import org.springframework.stereotype.Controller;
import com.chaitanya.csc_center.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
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

   @GetMapping("/dashboard")
    public String showUserDashboard() {
        return "user_dashboard"; // Corresponds to user_dashboard.html in templates
    }
}