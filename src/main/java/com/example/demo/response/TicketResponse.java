package com.example.demo.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TicketResponse {

    private String flightNumber;

    private LocalDateTime dateOfPurchase;

    private Long seatNumber;

    private String typeOfTicket;

    private Long price;

}
