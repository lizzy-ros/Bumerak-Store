package com.backend.repository;

import com.backend.model.ShippingAddres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddresRepository extends JpaRepository<ShippingAddres, Long> {
}