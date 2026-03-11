package com.lpu.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}