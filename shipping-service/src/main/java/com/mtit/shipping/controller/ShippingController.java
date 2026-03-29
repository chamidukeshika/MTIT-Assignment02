package com.mtit.shipping.controller;

import com.mtit.shipping.model.Shipping;
import com.mtit.shipping.service.ShippingService;
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
@RequestMapping("/shipping")
@Tag(name = "Shipping Service")
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return shippingService.info();
    }

    @GetMapping
    public List<Shipping> getAllShipments() {
        return shippingService.getAllShipments();
    }

    @GetMapping("/{id}")
    public Shipping getShipmentById(@PathVariable Long id) {
        return shippingService.getShipmentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shipping createShipment(@RequestBody Shipping shipping) {
        return shippingService.createShipment(shipping);
    }

    @PutMapping("/{id}")
    public Shipping updateShipment(@PathVariable Long id, @RequestBody Shipping shipping) {
        return shippingService.updateShipment(id, shipping);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShipment(@PathVariable Long id) {
        shippingService.deleteShipment(id);
    }
}
