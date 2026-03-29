package com.mtit.inventory.service;

import com.mtit.inventory.model.Inventory;
import com.mtit.inventory.repository.InventoryRepository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Map<String, String> info() {
        return Map.of(
                "service", "inventory-service",
                "status", "running",
                "swagger", "/swagger-ui/index.html",
                "gatewaySwagger", "/swagger-ui/index.html",
                "gatewayApiDocs", "/inventory-service/v3/api-docs");
    }

    public List<Inventory> getAllInventoryRecords() {
        return inventoryRepository.findAll();
    }

    public Inventory getInventoryRecordById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Inventory record not found: " + id));
    }

    public Inventory createInventoryRecord(Inventory inventory) {
        inventory.setId(null);
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventoryRecord(Long id, Inventory inventory) {
        Inventory existingInventory = getInventoryRecordById(id);
        existingInventory.setProductId(inventory.getProductId());
        existingInventory.setQuantityAvailable(inventory.getQuantityAvailable());
        existingInventory.setWarehouseLocation(inventory.getWarehouseLocation());
        existingInventory.setStockStatus(inventory.getStockStatus());
        return inventoryRepository.save(existingInventory);
    }

    public void deleteInventoryRecord(Long id) {
        Inventory existingInventory = getInventoryRecordById(id);
        inventoryRepository.delete(existingInventory);
    }
}
