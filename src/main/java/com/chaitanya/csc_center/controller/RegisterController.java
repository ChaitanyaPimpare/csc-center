package com.chaitanya.csc_center.controller;

import com.chaitanya.csc_center.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import com.chaitanya.csc_center.model.User;

@Controller
public class RegisterController {

    @Autowired
    private CustomerUserDetailsService userDetailsService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("users", new User()); // Add an empty user object to the model
        return "register"; // This should match register.html in /resources/templates/
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("users") User user) {
        // You can add validation here
        userDetailsService.saveUser(user); // Assuming you have a method to save the user
        return "redirect:/login"; // Redirect to the login page after successful registration
    }
}
