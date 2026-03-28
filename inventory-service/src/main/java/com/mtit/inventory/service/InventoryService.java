package com.mtit.inventory.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    public Map<String, String> info() {
        return Map.of(
                "service", "inventory-service",
                "status", "starter-scaffold",
                "nextStep", "implement CRUD endpoints");
    }
}
