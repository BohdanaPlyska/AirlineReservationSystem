package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.Date;
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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotBlank
    private String lastName;

    @Email
    @Column(name = "email")
    @NotBlank
    private String email;

    @Column(name = "password")
    @Size(min = 8, message = "at least 8 characters")
    @NotBlank
    private String password;

    @Transient
    private String passwordConfirm;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Column(name = "date_of_birth")
    @NotNull
    @Past
    private Date dateOfBirth;

    @Column(name = "passport_Number")
    @NotBlank
    private String passportNumber;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<PaymentEntity> payments;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "billingInformation_id", referencedColumnName = "id")
    private BillingInformationEntity billingInformation;

    @ManyToMany
    @JsonIgnore
    Set<TicketEntity> tickets;

}
