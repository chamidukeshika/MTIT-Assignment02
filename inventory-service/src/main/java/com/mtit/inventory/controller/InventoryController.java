package com.mtit.inventory.controller;

import com.mtit.inventory.model.Inventory;
import com.mtit.inventory.service.InventoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
@Tag(name = "Inventory Service")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return inventoryService.info();
    }

    @GetMapping
    public List<Inventory> getAllInventoryRecords() {
        return inventoryService.getAllInventoryRecords();
    }

    @GetMapping("/{id}")
    public Inventory getInventoryRecordById(@PathVariable Long id) {
        return inventoryService.getInventoryRecordById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory createInventoryRecord(@RequestBody Inventory inventory) {
        return inventoryService.createInventoryRecord(inventory);
    }

    @PutMapping("/{id}")
    public Inventory updateInventoryRecord(@PathVariable Long id, @RequestBody Inventory inventory) {
        return inventoryService.updateInventoryRecord(id, inventory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInventoryRecord(@PathVariable Long id) {
        inventoryService.deleteInventoryRecord(id);
    }
}
