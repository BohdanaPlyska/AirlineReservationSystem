package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "flights")
@NoArgsConstructor
public class FlightEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String flightNumber;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime departureTime;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime arrivalTime;

    private int capacity;

    private int numberOfStops;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticketId;

}
