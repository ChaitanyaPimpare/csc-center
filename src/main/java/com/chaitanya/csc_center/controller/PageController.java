package com.chaitanya.csc_center.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/services")
    public String servicesPage() {
        return "services"; // This should be in src/main/resources/templates/services.html
    }
}
