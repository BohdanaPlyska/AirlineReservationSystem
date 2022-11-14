package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

import static com.example.demo.constants.RegexConstants.VALIDATION_CONSTANT_TYPE_OF_FLIGHT;

@Data
public class FlightRequest {

    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_FLIGHT,
             message = " FlightEntity number should be two-character airline designator and a 1 to 4 digit number")
    private String flightNumber;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @NotNull
    @FutureOrPresent
    private LocalDateTime departureTime;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @NotNull
    @FutureOrPresent
    private LocalDateTime arrivalTime;

    @NotNull
    @Range(min = 1, message= "capacity may not be empty or less than null")
    @Max(500)
    private int capacity;

    @Range(min = 0)
    private int numberOfStops;

}
