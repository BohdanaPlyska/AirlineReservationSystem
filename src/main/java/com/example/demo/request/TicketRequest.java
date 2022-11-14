package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

import static com.example.demo.constants.RegexConstants.VALIDATION_CONSTANT_TYPE_OF_FLIGHT;
import static com.example.demo.constants.RegexConstants.VALIDATION_CONSTANT_TYPE_OF_TICKET;


@Data
public class TicketRequest {

    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_FLIGHT, message = " FlightEntity number should be two-character airline designator and a 1 to 4 digit number")
    @NotBlank(message = "this field can't be empty")
    private String flightNumber;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @NotNull
    @FutureOrPresent
    private LocalDateTime dateOfPurchase;

    @NotNull
    @Range(min = 1, message= "seat number may not be empty or null")
    @Max(500)
    private Long seatNumber;

    @NotBlank(message = "this field can't be empty")
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_TICKET,
            message = "typeOfTicket  should contains only characters and start uppercase character ")
    private String typeOfTicket;

    @NotNull
    @Range(min = 1)
    private Long price;

}
