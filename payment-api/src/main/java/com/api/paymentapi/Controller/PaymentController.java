package com.api.paymentapi.Controller;

import com.api.paymentapi.Model.Payment;
import java.util.UUID;
import com.api.paymentapi.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public ResponseEntity<Object> getPayments() {
        return ResponseEntity.ok().body(paymentService.getAllPayment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPayment(@PathVariable UUID id){
        return ResponseEntity.ok().body(paymentService.getPayment(id));
    }

    @PostMapping("/")
    public ResponseEntity<Object> savePayment(@RequestBody Payment payment){
        return ResponseEntity.ok().body(paymentService.savePayment(payment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePayment(@PathVariable ("id") UUID id, @RequestBody Payment payment){
        return ResponseEntity.ok().body(paymentService.updatePayment(id, payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePayment(@PathVariable ("id") UUID id){
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

}
