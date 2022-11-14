package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ReservationRequest {

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @NotNull
    private LocalDateTime reservationDateTime;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    @NotNull
    private LocalDateTime expirationDateTime;

    @NotNull
    @Range(min = 1, message= "ticket number may not be empty or null")
    private Long ticket;

}
