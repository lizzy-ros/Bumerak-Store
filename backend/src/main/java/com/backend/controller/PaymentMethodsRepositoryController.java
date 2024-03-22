package com.backend.controller;

import com.backend.model.PaymentMethods;
import com.backend.repository.PaymentMethodsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@Slf4j
@RestController
@AllArgsConstructor

public class PaymentMethodsRepositoryController {
    private PaymentMethodsRepository repoPayment;

    @GetMapping("payment")
    public List<PaymentMethods> findAll() {
        return repoPayment.findAll();
    }


    @GetMapping("payment/{id}")
    private ResponseEntity<PaymentMethods> finById(@PathVariable Long id){
        Optional<PaymentMethods> paymentMethods = repoPayment.findById(id);
        if (paymentMethods.isPresent() ) {
            return ResponseEntity.ok(paymentMethods.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("payment")
    private ResponseEntity<PaymentMethods> create(@RequestBody PaymentMethods paymentMethods){
        PaymentMethods address = repoPayment.save(paymentMethods);
        return ResponseEntity.ok(address);
    }

    @PutMapping("payment/{id}")
    private ResponseEntity<PaymentMethods> update(@RequestBody PaymentMethods paymentMethods, @PathVariable Long id){
        if (paymentMethods.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        PaymentMethods savePayment = repoPayment.save(paymentMethods);
        return ResponseEntity.ok(savePayment);
    }

    @DeleteMapping("payment/{id}")
    public ResponseEntity<PaymentMethods> deleteById(@PathVariable Long id) {
        repoPayment.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
