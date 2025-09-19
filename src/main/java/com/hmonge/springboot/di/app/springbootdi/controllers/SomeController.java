package com.hmonge.springboot.di.app.springbootdi.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.hmonge.springboot.di.app.springbootdi.models.Product;
import com.hmonge.springboot.di.app.springbootdi.services.IProductService;
//import com.hmonge.springboot.di.app.springbootdi.services.ProductServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private IProductService service;
    // private ProductServiceImpl service;
    // para desaclopar se utiliza la interfaz

    @GetMapping
    public List<Product> list() {
        // ProductService service = new ProductService();
        // Funciona para inmutabilidad pero no es recomendado
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        // ProductService service = new ProductService();
        // Funciona para inmutabilidad pero no es recomendado
        return service.findById(id);
    }
}
