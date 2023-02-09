package com.example.demo2maven.repository;


import com.example.demo2maven.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReposiory extends JpaRepository<Product, Integer> {
}
