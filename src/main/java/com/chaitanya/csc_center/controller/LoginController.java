package com.chaitanya.csc_center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // This should match login.html in /resources/templates/
    }
     @GetMapping("/access-denied")
    public String accessDenied() {
        return "access_denied"; // this should match access_denied.html
    }
}

