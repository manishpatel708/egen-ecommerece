package com.example.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
