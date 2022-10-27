package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "discountsProgram")
public class DiscountProgramEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "discountProgramId")
    private TicketEntity ticketId;

}
