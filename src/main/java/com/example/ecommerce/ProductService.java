package com.example.ecommerce;

import com.example.ecommerce.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.ecommerce.exception.ResourceNotFoundException;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("product with id " + id + " does not exist");
        }
        productRepository.deleteById(id);
    }
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product with id " + id + " does not exist"));
    }
    public Product updateProduct(Long id,Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("product with id " + id + "does not exist"));
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setCategory(product.getCategory());
        existing.setDescription(product.getDescription());
        existing.setStock(product.getStock());
        existing.setPrice(product.getPrice());
        return productRepository.save(existing);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
