package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "discountProgram")
public class DiscountProgramEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "discountProgram")
    @JsonIgnore
    private TicketEntity ticket;

}
