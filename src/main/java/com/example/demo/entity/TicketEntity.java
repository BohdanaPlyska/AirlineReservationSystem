package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "ticketEntity")
@NoArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "date_of_purchase")
    private LocalDateTime dateOfPurchase;

    @Column(name = "seat_number", nullable = false)
    private Long seatNumber;

    @Column(name = "type_of_ticket")
    private String typeOfTicket;

    @Column(name = "price")
    private Long price;

    @ManyToMany
    Set<UserEntity> user;

    @OneToOne( mappedBy = "ticket")
    private PaymentEntity payment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id")
    @JsonIgnore
    private DiscountProgramEntity discountProgram;

    @OneToOne(mappedBy = "ticket",orphanRemoval = true)
    @JsonIgnore
    private ReservationEntity reservation;

    @OneToMany(mappedBy = "ticket")
    @JsonIgnore
    private Set<FlightEntity> flights;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "billingInformation_id")
    @JsonIgnore
    private BillingInformationEntity billingInformation;

}
