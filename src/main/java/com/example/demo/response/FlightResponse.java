package com.example.demo.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightResponse {

    private String flightNumber;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private int capacity;

    private int numberOfStops;

}
