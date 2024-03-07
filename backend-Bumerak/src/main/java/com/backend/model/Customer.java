package com.backend.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "clientess")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String firtsName;

    private  String lastName;

    private  String email;

    private String password;

    private String shippingAddress;

    private String contactInformation;



}
