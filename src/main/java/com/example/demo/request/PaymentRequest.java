package com.example.demo.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.time.LocalDate;

import static com.example.demo.constants.RegexConstants.VALIDATION_CONSTANT_TYPE_OF_CVC;
import static com.example.demo.constants.RegexConstants.VALIDATION_CONSTANT_TYPE_OF_NAME_AND_SURNAME;

@Data
public class PaymentRequest {

    private Long id;

    @CreditCardNumber(message = "should not contain characters, and  contain 16 digit")
    @NotNull
    @NotBlank
    private String cardNumber;

    @NotNull
    @Pattern( regexp = VALIDATION_CONSTANT_TYPE_OF_CVC, message = "cvs can have 3 or 4 digits")
    private String cvc;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Future
    private LocalDate expirationDay;

    @NotNull
    private Boolean status;

    @NotBlank
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_NAME_AND_SURNAME,
            message = "ownerName  should contains only characters and start uppercase character ")
    private String ownerName;

    @NotBlank
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_NAME_AND_SURNAME,
            message = "ownerSurName  should contains only characters and start uppercase character ")
    private String ownerSurName;

    @NotNull
    @Range(min = 1)
    private Long finalPrice;

    @NotNull
    @Range(min = 1, message= "user id may not be empty or null")
    private Long user;

    @NotNull
    @Range(min = 1, message= "ticket number may not be empty or null")
    private Long ticket;

}
