package com.mtit.product.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Map<String, String> info() {
        return Map.of(
                "service", "product-service",
                "status", "starter-scaffold",
                "nextStep", "implement CRUD endpoints");
    }
}
