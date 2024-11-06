package com.example.jenkinstest;

import com.example.jenkinstest.dao.ProductDAO;
import com.example.jenkinstest.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JenkinsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner sampleData(ProductDAO productDAO) {
        return (args) -> {
            productDAO.save(new Product("Butter", "1234-5678-9012-1111", "Butter for your breakfast"));
            productDAO.save(new Product("Milk", "1234-5678-9012-2222", "Milk is better with cookies"));
        };
    }

}
