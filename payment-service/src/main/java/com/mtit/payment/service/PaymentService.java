package com.mtit.payment.service;

import com.mtit.payment.model.Payment;
import com.mtit.payment.repository.PaymentRepository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Map<String, String> info() {
        return Map.of(
                "service", "payment-service",
                "status", "running",
                "swagger", "/swagger-ui/index.html",
                "gatewaySwagger", "/swagger-ui/index.html",
                "gatewayApiDocs", "/payment-service/v3/api-docs");
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Payment not found: " + id));
    }

    public Payment createPayment(Payment payment) {
        payment.setId(null);
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment payment) {
        Payment existingPayment = getPaymentById(id);
        existingPayment.setOrderId(payment.getOrderId());
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setPaymentMethod(payment.getPaymentMethod());
        existingPayment.setPaymentStatus(payment.getPaymentStatus());
        return paymentRepository.save(existingPayment);
    }

    public void deletePayment(Long id) {
        Payment existingPayment = getPaymentById(id);
        paymentRepository.delete(existingPayment);
    }
}
