package com.lpu.product.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.product.entity.Product;
import com.lpu.product.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;
    
    
    @GetMapping("/get-product")
    public String getProduct() {
    	return "products: laptop,mobile";
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProductById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return "Product Deleted";
    }
}
