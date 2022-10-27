package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TicketRequest {
    private String flightNumber;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Timestamp dateOfPurchase;


    private int seatNumber;
    private String typeOfTicket;
    private Long price;
}
