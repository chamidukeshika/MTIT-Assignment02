package com.mtit.order.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public Map<String, String> info() {
        return Map.of(
                "service", "order-service",
                "status", "starter-scaffold",
                "nextStep", "implement CRUD endpoints");
    }
}
