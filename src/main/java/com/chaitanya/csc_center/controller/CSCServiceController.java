package com.chaitanya.csc_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.chaitanya.csc_center.model.CSCService;
import com.chaitanya.csc_center.service.CSCServiceService;

import java.util.List;

@RestController
@RequestMapping("/api/services")

@CrossOrigin("*")
public class CSCServiceController {
    @Autowired
    private CSCServiceService serviceService;

    @GetMapping
    public List<CSCService> getAllServices() {
        return serviceService.getAllServices();
    }

    @PostMapping
    public CSCService addService(@RequestBody CSCService service) {
        return serviceService.addService(service);
    }

    @GetMapping("/{id}")
    public CSCService getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }
}
