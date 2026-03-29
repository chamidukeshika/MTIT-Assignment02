package com.mtit.shipping.service;

import com.mtit.shipping.model.Shipping;
import com.mtit.shipping.repository.ShippingRepository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    public Map<String, String> info() {
        return Map.of(
                "service", "shipping-service",
                "status", "running",
                "swagger", "/swagger-ui/index.html",
                "gatewaySwagger", "/swagger-ui/index.html",
                "gatewayApiDocs", "/shipping-service/v3/api-docs");
    }

    public List<Shipping> getAllShipments() {
        return shippingRepository.findAll();
    }

    public Shipping getShipmentById(Long id) {
        return shippingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Shipment not found: " + id));
    }

    public Shipping createShipment(Shipping shipping) {
        shipping.setId(null);
        return shippingRepository.save(shipping);
    }

    public Shipping updateShipment(Long id, Shipping shipping) {
        Shipping existingShipment = getShipmentById(id);
        existingShipment.setOrderId(shipping.getOrderId());
        existingShipment.setShippingAddress(shipping.getShippingAddress());
        existingShipment.setCourierName(shipping.getCourierName());
        existingShipment.setTrackingNumber(shipping.getTrackingNumber());
        existingShipment.setShippingStatus(shipping.getShippingStatus());
        return shippingRepository.save(existingShipment);
    }

    public void deleteShipment(Long id) {
        Shipping existingShipment = getShipmentById(id);
        shippingRepository.delete(existingShipment);
    }
}
