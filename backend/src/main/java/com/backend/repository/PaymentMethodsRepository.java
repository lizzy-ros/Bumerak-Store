package com.backend.repository;

import com.backend.model.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Long> {
}