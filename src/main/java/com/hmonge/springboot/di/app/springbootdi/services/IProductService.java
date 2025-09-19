package com.hmonge.springboot.di.app.springbootdi.services;

import java.util.List;
import com.hmonge.springboot.di.app.springbootdi.models.Product;

public interface IProductService {

    List<Product> findAll();

    Product findById(Long id);

}
