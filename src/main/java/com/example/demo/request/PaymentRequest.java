package com.example.demo.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PaymentRequest {

    @CreditCardNumber
    @NotNull
    private String cardNumber;

    @NotNull
    @Size(min = 3, max = 4)
    private int cvc;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate expirationDay;

    @NotNull
    private Boolean status;

    @NotBlank
    private String ownerName;

    @NotBlank
    private String ownerSurName;

    @NotNull
    private Long finalPrice;

    @NotNull
    private Long user;

    @NotNull
    private Long ticket;
}
