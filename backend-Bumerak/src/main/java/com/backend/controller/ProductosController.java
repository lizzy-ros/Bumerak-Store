package com.backend.controller;

import com.backend.model.Productos;
import com.backend.model.ShoppingList;
import com.backend.repository.ProductoRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ProductosController {


    private final ProductoRepository productoRepository;
    @GetMapping("productos")
    public List<Productos> findAll() {
        return productoRepository.findAll();
    }


    @GetMapping("productos/{id}")
    private ResponseEntity<Productos> finById(@PathVariable Long id){
        Optional<Productos> productos= productoRepository.findById(id);
        if (productos.isPresent() ) {
            return ResponseEntity.ok(productos.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("productos")
    private ResponseEntity<Productos> create(@RequestBody Productos productos){
        Productos saveProductos = productoRepository.save(productos);
        return ResponseEntity.ok(saveProductos);
    }

    @PutMapping("productos/{id}")
    private ResponseEntity<Productos> update(@RequestBody Productos productos,@PathVariable Long id){
        if (productos.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Productos saveProductos = productoRepository.save(productos);
        return ResponseEntity.ok(productos);
    }

    @DeleteMapping("productos/{id}")
    public ResponseEntity<Productos> deleteById(@PathVariable Long id) {
        productoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
