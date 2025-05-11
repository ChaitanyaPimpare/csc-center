package com.chaitanya.csc_center.controller;

import com.chaitanya.csc_center.model.CSCService;
import com.chaitanya.csc_center.service.CSCServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin/services") // Accessible only by admin
public class AdminServiceController {

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
