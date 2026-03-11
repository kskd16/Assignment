package com.lpu.payment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.lpu.payment.entity.Payment;
import com.lpu.payment.entity.User;
import com.lpu.payment.service.PaymentService;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;
    
    
    @GetMapping("/rt")
    public ResponseEntity<String> takeDataFromUser(){
    	String url = "http://localhost:8081/users/all";
    	RestTemplate template = new RestTemplate();
    	ResponseEntity<String> response = template.exchange(url,HttpMethod.GET,null,String.class);
    	
    	
    	return response;
    }
    
    
    @PostMapping("/rt/createUser")
    public ResponseEntity<String> createUser(){
    	String url = "http://localhost:8081/users/create";
    	RestTemplate temp = new RestTemplate();
    	User user = new User();
    	user.setName("jkl");
    	user.setPhone("5656523");
    	
    	return temp.postForEntity(url,user,String.class);
    }
    
   @GetMapping("/rt/getById")
   public ResponseEntity<String> takeUserById(){
	   String url = "http://localhost:8081/users/get/3";
	   RestTemplate template = new RestTemplate();
	   return template.exchange(url,HttpMethod.GET,null,String.class);
   }

    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        return service.savePayment(payment);
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }

    @GetMapping("/get/{id}")
    public Payment getPayment(@PathVariable int id) {
        return service.getPaymentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable int id) {
        service.deletePayment(id);
        return "Payment Deleted";
    }
}