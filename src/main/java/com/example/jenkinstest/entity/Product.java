package com.example.jenkinstest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    private String description;

    public Product(String initialName, String initialCode,
                   String initialDescription) {
        this.name = initialName;
        this.code = initialCode;
        this.description = initialDescription;
        String text = null;
        System.out.println(text.length());
    }
}
