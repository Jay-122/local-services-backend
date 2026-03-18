package com.jay.localservices.repository;

import com.jay.localservices.model.ServiceProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

    Page<ServiceProvider> findByCategory(String category, Pageable pageable);

}