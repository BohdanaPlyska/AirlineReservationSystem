package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    private BigInteger cardNumber;

    private int cvc;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate expirationDay;

    private Boolean status;

    private String ownerName;

    private String ownerSurName;

    private Long finalPrice;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userId;//rename

    @OneToOne( cascade=CascadeType.ALL)
    @JoinColumn(name = "ticket_id", nullable = false)
    private TicketEntity ticket;//rename

}
