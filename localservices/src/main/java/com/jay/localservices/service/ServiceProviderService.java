package com.jay.localservices.service;

import com.jay.localservices.model.ServiceProvider;
import com.jay.localservices.repository.ServiceProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ServiceProviderService {

    private final ServiceProviderRepository serviceProviderRepository;

    public ServiceProviderService(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }


    public ServiceProvider createProvider(ServiceProvider provider) {
        return serviceProviderRepository.save(provider);
    }


    public Page<ServiceProvider> getAllProviders(Pageable pageable) {
        return serviceProviderRepository.findAll(pageable);
    }

    public Page<ServiceProvider> getProvidersByCategory(String category, Pageable pageable) {
        return serviceProviderRepository.findByCategory(category, pageable);
    }

    public ServiceProvider getProviderById(Long id) {
        return serviceProviderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
    }

    public ServiceProvider updateProvider(Long id, ServiceProvider updated) {

        ServiceProvider existing = serviceProviderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        existing.setName(updated.getName());
        existing.setCategory(updated.getCategory());
        existing.setLocation(updated.getLocation());
        existing.setPhone(updated.getPhone());

        return serviceProviderRepository.save(existing);
    }

    public void deleteProvider(Long id) {

        ServiceProvider existing = serviceProviderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        serviceProviderRepository.delete(existing);
    }
}