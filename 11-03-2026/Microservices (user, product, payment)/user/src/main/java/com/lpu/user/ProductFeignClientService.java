package com.lpu.user;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lpu.user.entity.Product;

@FeignClient("PRODUCT")
public interface ProductFeignClientService {
	
	@GetMapping("/products/get-product")
	public String getProduct();
	
	@GetMapping("/products/all")
	List<Product> getAllProducts();
	
	@GetMapping("/products/get/{id}")
	Product getProduct(@PathVariable int id);
	
	@PostMapping("/products/create")
	Product createProduct(@RequestBody Product product);
	
}
