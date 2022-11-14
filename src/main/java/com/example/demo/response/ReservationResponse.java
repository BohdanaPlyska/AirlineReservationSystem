package com.example.demo.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationResponse {

    private LocalDateTime reservationDateTime;

    private LocalDateTime expirationDateTime;

}
