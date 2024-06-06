package org.example.demo_api_crud.controller;

import org.example.demo_api_crud.model.entity.Product;
import org.example.demo_api_crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{proId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer proId){
        return new ResponseEntity<>(productService.findProductById(proId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.update(product),HttpStatus.OK);
    }

    @DeleteMapping("/{proId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer proId){
        productService.delete(proId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getByName/{proName}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String proName){
        return new ResponseEntity<>(productService.findProductsByName(proName), HttpStatus.OK);
    }
}
