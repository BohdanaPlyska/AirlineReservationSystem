package com.example.demo.request;

import com.example.demo.entity.TicketEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
public class ReservationRequest {

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime reservationDateTime;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime expirationDateTime;//will update by algorithm when we have a lot of tickets

    private Long ticketId;
}
