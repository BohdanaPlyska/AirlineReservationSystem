package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String password;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateOfBirth;

    private BigInteger passportNumber;

    @OneToMany(mappedBy = "userId")
    @JsonManagedReference
    private Set<PaymentEntity> payments;

    @OneToOne
    @JoinColumn(name = "billingInformation_id", referencedColumnName = "id")
    private BillingInformationEntity billingInformationId;

    @ManyToMany
    Set<TicketEntity> ticketId;



}
