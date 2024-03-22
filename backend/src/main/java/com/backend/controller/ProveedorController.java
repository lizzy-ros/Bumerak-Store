package com.backend.controller;

import com.backend.model.Productos;
import com.backend.model.Proveedor;
import com.backend.repository.ProveedorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@Slf4j
public class ProveedorController {

    private  final ProveedorRepository proveeRepo;

    @GetMapping("proveedor")
    public List<Proveedor> findAll(){
        log.info("REST request to finAll productos");
        return this.proveeRepo.findAll();
    }
    @GetMapping("proveedor/{id}")
    private ResponseEntity<Proveedor> finById(@PathVariable Long id){
        Optional<Proveedor> proveedor= proveeRepo.findById(id);
        if (proveedor.isPresent() ) {
            return ResponseEntity.ok(proveedor.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("proveedor")
    private ResponseEntity<Proveedor> create(@RequestBody Proveedor proveedor){
        Proveedor  saveProveedor = proveeRepo.save(proveedor);
        return ResponseEntity.ok(saveProveedor);
    }

    @PutMapping("proveedor/{id}")
    private ResponseEntity<Proveedor> update(@RequestBody Proveedor proveedor,@PathVariable Long id){
        if (proveedor.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        Proveedor saveProveedor = proveeRepo.save(proveedor);
        return ResponseEntity.ok(saveProveedor);
    }

    @DeleteMapping("proveedor/{id}")
    public ResponseEntity<Proveedor> deleteById(@PathVariable Long id) {
        proveeRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
