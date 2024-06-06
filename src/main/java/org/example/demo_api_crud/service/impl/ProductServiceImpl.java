package org.example.demo_api_crud.service.impl;

import org.example.demo_api_crud.model.entity.Product;
import org.example.demo_api_crud.repository.ProductRepository;
import org.example.demo_api_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Integer proId) {
        return productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Khong ton tai san pham"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        productRepository.findById(product.getProId()).orElseThrow(()->new NoSuchElementException("Khong ton tai san pham"));
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer proId) {
        productRepository.deleteById(proId);
    }

    @Override
    public List<Product> findProductsByName(String proName) {
//        if(proName!=null && !proName.isEmpty())
//            proName = "%"+proName+"%";
//        else
//            proName = "%";
        return productRepository.findProductsByProName(proName);
    }
}
