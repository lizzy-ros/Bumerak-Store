package com.backend.controller;

import com.backend.model.Customer;
import com.backend.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerRepository repo;
    @GetMapping("customer")
    private List<Customer> findAll(){

        return repo.findAll();
    }


    @GetMapping("customer/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id){
        Optional<Customer> customer = repo.findById(id);
        if (customer.isPresent()){
            return ResponseEntity.ok(customer.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("customer")
    private ResponseEntity<Customer> create(@RequestBody Customer customer){
        Customer saveCustomer = repo.save(customer);
        return ResponseEntity.ok(saveCustomer);
    }

    @PutMapping ("customer/{id}")
    private ResponseEntity<Customer> update(@RequestBody Customer customer,@PathVariable Long id){

        if (customer.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Customer saveList = repo.save(customer);
        return ResponseEntity.ok(saveList);
    }
    @DeleteMapping("customer/{id}")
    private ResponseEntity<Customer> delete(@PathVariable Long id) {
        repo.deleteById(id);
       return ResponseEntity.ok().build();
    }
}
