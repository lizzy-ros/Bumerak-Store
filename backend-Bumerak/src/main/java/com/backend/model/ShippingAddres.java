package com.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "direccion_envio")
public class ShippingAddres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String city;

    private String postaCode;

    private String country;

    @ManyToOne
    @JoinColumn(name = ("customer_id"))
    private Customer customer;

}
