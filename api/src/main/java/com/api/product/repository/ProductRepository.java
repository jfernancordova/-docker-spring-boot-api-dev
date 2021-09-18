package com.api.product.repository;

import com.api.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    public List<Product> findAll();

    public Product findByUuid(String uuid);
}

