package com.example.demo.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Payment;

@Repository
@EnableJpaRepositories
public interface PaymentRepository extends JpaRepository<Payment,Long>{
	
Payment findByTransactionId(String transactionId);
Payment findByPaymentIdentifier(String paymentIdentifier);

//List<Payment> findByPaymentIdentifier(String paymentIdentifier);
}