package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class TicketRequest {

    @Pattern(regexp = "^[A-Z\\d]{2}[A-Z]?\\d{1,4}[A-Z]?$", message = " Flight number should be two-character airline designator and a 1 to 4 digit number")
    @NotBlank(message = "this field can't be empty")
    private String flightNumber;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @NotNull
    private LocalDateTime dateOfPurchase;

    @NotNull
    private Long seatNumber;

    @NotBlank(message = "this field can't be empty")
    private String typeOfTicket;

    @NotNull
    private Long price;



}
