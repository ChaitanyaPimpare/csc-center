package com.chaitanya.csc_center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/appointments")
    public String home() {
        return "appointments"; // Loads src/main/resources/templates/index.html
    }


    @GetMapping("/index")
    public String indexPage() {
        return "index";  // Loads index.html after successful login
    }
}
