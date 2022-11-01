package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class FlightRequest {

    private Long id;

    @Pattern(regexp = "^[A-Z\\d]{2}[A-Z]?\\d{1,4}[A-Z]?$", message = " Flight number should be two-character airline designator and a 1 to 4 digit number")
    private String flightNumber;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @NotNull
    private LocalDateTime departureTime;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @NotNull
    private LocalDateTime arrivalTime;

    @NotNull
    private int capacity;

    @NotNull
    private int numberOfStops;

}
