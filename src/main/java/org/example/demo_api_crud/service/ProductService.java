package org.example.demo_api_crud.service;

import org.example.demo_api_crud.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findProductById(Integer proId);
    Product save(Product product);
    Product update(Product product);
    void delete(Integer proId);
    List<Product> findProductsByName(String proName);
}
