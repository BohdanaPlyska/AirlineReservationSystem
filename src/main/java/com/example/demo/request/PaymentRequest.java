package com.example.demo.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class PaymentRequest {
    private Long id;

    private BigInteger cardNumber;

    private int cvc;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate expirationDay;

    private Boolean status;

    private String ownerName;

    private String ownerSurName;

    private Long finalPrice;

    private Long userId;

    private Long ticketId;
}
