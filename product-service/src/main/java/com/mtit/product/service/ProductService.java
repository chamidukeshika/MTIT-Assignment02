package com.mtit.product.service;

import com.mtit.product.model.Product;
import com.mtit.product.repository.ProductRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<String, String> info() {
        Map<String, String> details = new LinkedHashMap<>();
        details.put("purpose", "Products");
        details.put("directBaseUrl", "http://localhost:8081/products");
        details.put("gatewayBaseUrl", "http://localhost:8080/api/products");
        details.put("gatewayPath", "GET, POST, PUT, DELETE");
        return details;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Product not found: " + id));
    }

    public Product createProduct(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStatus(product.getStatus());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        Product existingProduct = getProductById(id);
        productRepository.delete(existingProduct);
    }
}
