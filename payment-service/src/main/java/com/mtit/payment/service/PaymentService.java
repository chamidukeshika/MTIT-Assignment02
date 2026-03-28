package com.mtit.payment.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Map<String, String> info() {
        return Map.of(
                "service", "payment-service",
                "status", "starter-scaffold",
                "nextStep", "implement CRUD endpoints");
    }
}
