package com.lpu.payment.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.payment.entity.Payment;
import com.lpu.payment.repo.PaymentRepository;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    public Payment savePayment(Payment payment) {
        return repo.save(payment);
    }

    public List<Payment> getAllPayments() {
        return repo.findAll();
    }

    public Payment getPaymentById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void deletePayment(int id) {
        repo.deleteById(id);
    }
}