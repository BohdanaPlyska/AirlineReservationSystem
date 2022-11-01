package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightResponse {

    private Long id;

    private String flightNumber;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private int capacity;

    private int numberOfStops;
}
