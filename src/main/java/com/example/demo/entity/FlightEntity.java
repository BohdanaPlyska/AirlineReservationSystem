package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "flightEntity")
@NoArgsConstructor
public class FlightEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "number_of_stops")
    private int numberOfStops;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    @JsonIgnore
    private TicketEntity ticket;

}
