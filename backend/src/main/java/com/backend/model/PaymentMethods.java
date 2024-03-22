package com.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "methods_pago")
public class PaymentMethods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private CardType cardType;

    private Long cardNumber;

    private LocalDate dueDate;

    private String securityCode;
    @ManyToOne
    private User user;


}
