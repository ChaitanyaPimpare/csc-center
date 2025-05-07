package com.chaitanya.csc_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chaitanya.csc_center.model.CSCService;
import com.chaitanya.csc_center.repository.CSCServiceRepository;

import java.util.List;

@Service
public class CSCServiceService {
    @Autowired
    private CSCServiceRepository serviceRepository;

    public List<CSCService> getAllServices() {
        return serviceRepository.findAll();
    }

    public CSCService addService(CSCService service) {
        return serviceRepository.save(service);
    }

    public CSCService getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
