package com.lpu.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.lpu.user.ProductFeignClientService;
import com.lpu.user.entity.Payment;
import com.lpu.user.entity.Product;
import com.lpu.user.entity.User;
import com.lpu.user.service.UserService;


@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService service;
    
    @Autowired
    ProductFeignClientService productService;
    
    @GetMapping("/product")
    public String getProductInUser() {
    	return productService.getProduct();
    }
    
    @GetMapping("/pall")
    public List<Product> getPAll() {
    	return productService.getAllProducts();
    }
    
    @GetMapping("/pGet/{id}")
    public Product getById(@PathVariable int id) {
    	return productService.getProduct(id);
    }
    
    @PostMapping("/pCreate")
    public Product createProduct(@RequestBody Product product) {
    	return productService.createProduct(product);
    }
    
    @GetMapping("/save")
    public String save() {
    	//System.err.println("sdfghj");
    	return "hiiiiii!!!";
    	
    }
    
    @GetMapping("/rt/all")
    public ResponseEntity<String> takeAllDataFromPayment(){
    	String url = "http://localhost:8071/payments/all";
    	RestTemplate temp = new RestTemplate();
    	return temp.exchange(url,HttpMethod.GET,null,String.class);
    }
    @GetMapping("/rt/getById")
    public ResponseEntity<String> takeByIdFromPayment(){
    	String url = "http://localhost:8071/payments/get/1";
    	RestTemplate temp = new RestTemplate();
    	return temp.exchange(url,HttpMethod.GET,null,String.class);
    }
    
    @PostMapping("/rt/createPayment")
    public ResponseEntity<String> createUser(){
    	String url = "http://localhost:8071/payments/create";
    	RestTemplate temp = new RestTemplate();
    	Payment pay = new Payment(); 
    	pay.setAmount(85623.00);
    	pay.setMethod("UPI");
    	return temp.postForEntity(url,pay,String.class);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return service.saveUser(user);
        //return "USER CREATED";
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable int id) {
        return service.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return "User Deleted";
    }
}
