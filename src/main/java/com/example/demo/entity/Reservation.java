package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reservations")
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reservation_date_time")
    private LocalDateTime reservationDateTime;

    @Column(name = "expiration_date_time")
    private LocalDateTime expirationDateTime;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

}
