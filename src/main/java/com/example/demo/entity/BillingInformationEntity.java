package com.example.demo.entity;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity(name = "billingsInformation")
public class BillingInformationEntity {
    @Id
    @GeneratedValue
    private Long id;

    @CreditCardNumber
    private BigInteger cardNumber;
    private int Cvc;
    private LocalDateTime expirationDay;
    private Boolean status;
    private String ownerName;
    private String ownerSurName;
    private String countryOfRegistrationCard;
    private String cityOfRegistrationCard;
    private String streetAddress;
    private Long price;

    @OneToOne(mappedBy = "billingInformationId")
    private UserEntity userId;
}
