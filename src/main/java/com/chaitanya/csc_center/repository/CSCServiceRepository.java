package com.chaitanya.csc_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chaitanya.csc_center.model.CSCService;

public interface CSCServiceRepository extends JpaRepository<CSCService, Long> {
    // No extra code needed
}
