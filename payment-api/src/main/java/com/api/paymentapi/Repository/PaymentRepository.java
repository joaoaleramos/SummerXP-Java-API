package com.api.paymentapi.Repository;

import java.util.UUID;

import com.api.paymentapi.Model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

}
