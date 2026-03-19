package com.jay.localservices.controller;

import com.jay.localservices.model.ServiceProvider;
import com.jay.localservices.service.ServiceProviderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ServiceProvider createProvider(@RequestBody ServiceProvider provider) {
        return serviceProviderService.createProvider(provider);
    }

    @GetMapping
    public Page<ServiceProvider> getProviders(
            @RequestParam(required = false) String category,
            Pageable pageable
    ) {

        if (category != null) {
            return serviceProviderService.getProvidersByCategory(category, pageable);
        }

        return serviceProviderService.getAllProviders(pageable);
    }

    @GetMapping("/{id}")
    public ServiceProvider getProviderById(@PathVariable Long id) {
        return serviceProviderService.getProviderById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ServiceProvider updateProvider(@PathVariable Long id,
                                          @RequestBody ServiceProvider provider) {
        return serviceProviderService.updateProvider(id, provider);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProvider(@PathVariable Long id) {
        serviceProviderService.deleteProvider(id);
    }

}