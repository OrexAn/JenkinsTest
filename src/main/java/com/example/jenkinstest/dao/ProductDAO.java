package com.example.jenkinstest.dao;

import com.example.jenkinstest.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
}
