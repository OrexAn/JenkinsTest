package com.example.jenkinstest.controller;

import com.example.jenkinstest.dao.ProductDAO;
import com.example.jenkinstest.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProductController {
    private final ProductDAO productDAO;

    public ProductController(ProductDAO initialProductDAO) {
        this.productDAO = initialProductDAO;
    }

    @GetMapping(value = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> getProducts() {
        return productDAO.findAll();
    }

    @GetMapping(value = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProducts(@PathVariable long id) {
        return productDAO.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid product id: %s", id)));
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product createProduct(@RequestBody Product product) {
        return productDAO.save(product);
    }
}
