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
public class ReservationEntity {
    @Id
    @GeneratedValue
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime reservationDateTime;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime expirationDateTime;//will update by algorithm when we have a lot of tickets

    @OneToOne(mappedBy = "reservationId")
    private TicketEntity ticketId;

}
