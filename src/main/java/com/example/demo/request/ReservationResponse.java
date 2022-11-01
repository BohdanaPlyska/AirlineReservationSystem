package com.example.demo.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationResponse {

    private Long id;

    private LocalDateTime reservationDateTime;

    private LocalDateTime expirationDateTime;

}
