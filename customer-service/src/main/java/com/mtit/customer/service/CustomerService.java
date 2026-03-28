package com.mtit.customer.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Map<String, String> info() {
        return Map.of(
                "service", "customer-service",
                "status", "starter-scaffold",
                "nextStep", "implement CRUD endpoints");
    }
}
