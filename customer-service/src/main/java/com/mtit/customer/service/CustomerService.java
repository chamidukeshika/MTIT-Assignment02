package com.mtit.customer.service;

import com.mtit.customer.model.Customer;
import com.mtit.customer.repository.CustomerRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Map<String, String> info() {
        Map<String, String> details = new LinkedHashMap<>();
        details.put("purpose", "Customers");
        details.put("directBaseUrl", "http://localhost:8082/customers");
        details.put("gatewayBaseUrl", "http://localhost:8080/api/customers");
        details.put("gatewayPath", "GET, POST, PUT, DELETE");
        return details;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Customer not found: " + id));
    }

    public Customer createCustomer(Customer customer) {
        customer.setId(null);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddress(customer.getAddress());
        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id) {
        Customer existingCustomer = getCustomerById(id);
        customerRepository.delete(existingCustomer);
    }
}
