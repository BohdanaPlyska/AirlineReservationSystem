package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "tickets")
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String flightNumber;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateOfPurchase;

    private int seatNumber;

    private String typeOfTicket;

    private Long price;

    @ManyToMany
    Set<UserEntity> userId;

    @OneToOne( mappedBy = "ticket")
//    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentEntity payment;


    @OneToOne
    @JoinColumn(name = "discount_id", referencedColumnName = "id")
    private DiscountProgramEntity discountProgramId;

    @OneToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private ReservationEntity reservationId;

    @OneToMany(mappedBy = "ticketId")
    private Set<FlightEntity> flightId;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "billingInformation_id", referencedColumnName= "id")
    private BillingInformationEntity billingInformationId;


}
