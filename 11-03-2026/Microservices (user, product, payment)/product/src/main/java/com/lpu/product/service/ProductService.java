package com.lpu.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.product.entity.Product;
import com.lpu.product.repo.ProductRepository;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product saveProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
