package com.hmonge.springboot.di.app.springbootdi.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hmonge.springboot.di.app.springbootdi.models.Product;

// Encargado de interactuar con los datos

@Repository("productFoo")
public class ProductRepositoryFoo implements IProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27\"", 800L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Monitor Asus 27\"", 800L);
    }

}
