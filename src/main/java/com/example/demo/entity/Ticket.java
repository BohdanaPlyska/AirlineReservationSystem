package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "tickets")
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "date_of_purchase")
    private LocalDateTime dateOfPurchase;

    @Column(name = "seat_number")
    private Long seatNumber;

    @Column(name = "type_of_ticket")
    private String typeOfTicket;

    @Column(name = "price")
    private Long price;

    @ManyToMany
    Set<User> user;

    @OneToOne( mappedBy = "ticket")
    private Payment payment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id")
    private DiscountProgram discountProgram;

    @OneToOne(mappedBy = "ticket")
    private Reservation reservation;

    @OneToMany(mappedBy = "ticket")
    private Set<Flight> flights;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "billingInformation_id")
    private BillingInformation billingInformation;

}
