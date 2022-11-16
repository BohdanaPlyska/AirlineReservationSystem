package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvc")
    private String cvc;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "expiration_day")
    private LocalDate expirationDay;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_sur_name")
    private String ownerSurName;

    @Column(name = "final_price")
    private Long finalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private UserEntity user;

    @OneToOne( cascade=CascadeType.ALL)
    @JoinColumn(name = "ticket_id", nullable = false)
    @JsonIgnore
    private TicketEntity ticket;

}
