package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnore
    private DiscountProgram discountProgram;

    @OneToOne(mappedBy = "ticket")
    @JsonIgnore
    private Reservation reservation;

    @OneToMany(mappedBy = "ticket")
    @JsonIgnore
    private Set<Flight> flights;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "billingInformation_id")
    @JsonIgnore
    private BillingInformation billingInformation;

}
