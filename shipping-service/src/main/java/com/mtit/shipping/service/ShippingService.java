package com.mtit.shipping.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public Map<String, String> info() {
        return Map.of(
                "service", "shipping-service",
                "status", "starter-scaffold",
                "nextStep", "implement CRUD endpoints");
    }
}
