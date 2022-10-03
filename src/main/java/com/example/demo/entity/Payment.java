package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "payments")
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    private BigInteger cardNumber;
    private LocalDateTime date;
    private Boolean status;
    private Long price;

}
