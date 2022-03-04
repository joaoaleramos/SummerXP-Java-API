package com.api.paymentapi.Service;

import java.util.List;
import java.util.UUID;


import com.api.paymentapi.Model.Payment;
import com.api.paymentapi.Repository.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

     public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    public Payment getPayment(UUID id) {
        return paymentRepository.getById(id);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(UUID id, Payment payment) {
        Payment actualPayment = paymentRepository.getById(id);
        BeanUtils.copyProperties(payment, actualPayment, "id");
        return paymentRepository.save(actualPayment);
    }

    public void deletePayment(UUID id) {
        paymentRepository.deleteById(id);
    }

}
