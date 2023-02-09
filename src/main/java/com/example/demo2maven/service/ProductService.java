package com.example.demo2maven.service;


import com.example.demo2maven.entity.Product;
import com.example.demo2maven.repository.ProductReposiory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductReposiory productReposiory;

    public Product save(Product product) {
        return productReposiory.save(product);
    }

    public List<Product> findAll() {
        List<Product> reposioryAll = productReposiory.findAll();
        log.info("all repository: {}",reposioryAll);
        return reposioryAll;
    }

    public Product update(Product product){
        Product savedProduct=Product.builder().build();
        Optional<Product> productFromDb= productReposiory.findById(product.getId());
        productFromDb.ifPresent(p->{
            Product save = productReposiory.save(p);
            savedProduct.setId(save.getId());
            savedProduct.setName(save.getName());
            savedProduct.setPrice(save.getPrice());
        });
        log.info("saved Product: {}",productFromDb);
        return savedProduct;
    }

}
