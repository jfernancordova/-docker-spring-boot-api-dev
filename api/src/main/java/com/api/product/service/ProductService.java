package com.api.product.service;

import com.api.product.model.Product;
import com.api.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableMongoRepositories("com.api.product.repository")
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void saveOrUpdateProduct(Product product) {
        productRepository.save(product);
    }

    public Product findByUuid(String uuid) {
        return productRepository.findByUuid(uuid);
    }

    public void deleteProductByUuid(String uuid) {
        productRepository.deleteById(uuid);
    }
}
