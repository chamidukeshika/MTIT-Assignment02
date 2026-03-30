package com.mtit.order.service;

import com.mtit.order.model.Order;
import com.mtit.order.repository.OrderRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Map<String, String> info() {
        Map<String, String> details = new LinkedHashMap<>();
        details.put("purpose", "Orders");
        details.put("directBaseUrl", "http://localhost:8084/orders");
        details.put("gatewayBaseUrl", "http://localhost:8080/api/orders");
        details.put("gatewayPath", "GET, POST, PUT, DELETE");
        return details;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Order not found: " + id));
    }

    public Order createOrder(Order order) {
        order.setId(null);
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);
        existingOrder.setCustomerId(order.getCustomerId());
        existingOrder.setProductId(order.getProductId());
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setTotalAmount(order.getTotalAmount());
        existingOrder.setOrderStatus(order.getOrderStatus());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        Order existingOrder = getOrderById(id);
        orderRepository.delete(existingOrder);
    }
}
