package com.backend.controller;

import com.backend.model.ShippingAddres;
import com.backend.repository.ShippingAddresRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor


public class ShippingAddressController {
    private final ShippingAddresRepository addressRepository;

    @GetMapping("address")
    public List<ShippingAddres> findAll() {
        return addressRepository.findAll();
    }


    @GetMapping("address/{id}")
    private ResponseEntity<ShippingAddres> finById(@PathVariable Long id){
        Optional<ShippingAddres> shippingAddress= addressRepository.findById(id);
        if (shippingAddress.isPresent() ) {
            return ResponseEntity.ok(shippingAddress.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("address")
    private ResponseEntity<ShippingAddres> create(@RequestBody ShippingAddres shippingAddres){
        ShippingAddres address = addressRepository.save(shippingAddres);
        return ResponseEntity.ok(address);
    }

    @PutMapping("address/{id}")
    private ResponseEntity<ShippingAddres> update(@RequestBody ShippingAddres shippingAddres, @PathVariable Long id){
        if (shippingAddres.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        ShippingAddres address = addressRepository.save(shippingAddres);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("address/{id}")
    public ResponseEntity<ShippingAddres> deleteById(@PathVariable Long id) {
        addressRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

   

}
