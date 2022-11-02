package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity(name = "billingsInformation")
public class BillingInformation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @CreditCardNumber
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvc")
    @Size(min = 3, max = 4)
    private int cvc;

    @Column(name = "expiration_day")
    @Future
    private LocalDateTime expirationDay;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_surname")
    private String ownerSurName;

    @Column(name = "country_of_registration_card")
    private String countryOfRegistrationCard;

    @Column(name = "city_of_registration_card")
    private String cityOfRegistrationCard;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "price")
    private Long price;

    @OneToOne(mappedBy = "billingInformation")
    private User user;


    @OneToOne(mappedBy = "billingInformation")
    @JsonIgnore
    private Ticket ticket;
}
