package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "discountsProgram")
public class DiscountProgram {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "discountProgram")
    private Ticket ticket;

}
