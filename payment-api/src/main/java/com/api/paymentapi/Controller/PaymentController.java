package com.api.paymentapi.Controller;

import com.api.paymentapi.Model.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.api.paymentapi.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getPayments() {
        return ResponseEntity.ok().body(paymentService.getAllPayment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPayment(@PathVariable UUID id) {
        return ResponseEntity.ok().body(paymentService.getPayment(id));
    }

    @PostMapping("/post/")
    public ResponseEntity<Object> savePayment(@RequestBody Payment payment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.savePayment(payment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePayment(@PathVariable("id") UUID id, @RequestBody @Valid Payment payment) {
        return ResponseEntity.ok().body(paymentService.updatePayment(id, payment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePayment(@PathVariable("id") UUID id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

}
