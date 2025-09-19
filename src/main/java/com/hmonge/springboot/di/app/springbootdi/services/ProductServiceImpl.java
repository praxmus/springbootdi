package com.hmonge.springboot.di.app.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hmonge.springboot.di.app.springbootdi.models.Product;
import com.hmonge.springboot.di.app.springbootdi.repositories.IProductRepository;
//import com.hmonge.springboot.di.app.springbootdi.repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements IProductService {

    // Se encarga de manejar las transacciones

    // @Autowired
    // private Environment environment;

    @Value("${config.price.tax}")
    private Double tax;

    // @Autowired
    // @Qualifier("productList")
    private IProductRepository repository;
    // private ProductRepositoryImpl repository;
    // para desaclopar se utiliza la interfaz

    public ProductServiceImpl(@Qualifier("productJson") IProductRepository repository) {
        this.repository = repository;
    }

    /*
     * public List<Product> findAll() {
     * return repository.findAll().stream().map(p -> {
     * Double priceTax = p.getPrice() * 1.25d;
     * Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
     * // p.setPrice(priceTax.longValue());
     * // Se elimina la linea anterior para aplicar el
     * // principio de inmutabilidad
     * return newProd;
     * }).collect(Collectors.toList());
     * }
     */

    /*
     * @Override
     * public List<Product> findAll() {
     * return repository.findAll().stream().map(p -> {
     * Double priceTax = p.getPrice() * 1.25d;
     * // Product newProd = (Product) p.clone();
     * // newProd.setPrice(priceTax.longValue());
     * p.setPrice(priceTax.longValue());
     * return p;
     * }).collect(Collectors.toList());
     * }
     */

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * tax;

            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;

            // p.setPrice(priceTax.longValue());
            // return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
