package com.lpu.product.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.product.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}