package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Email;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
public class UserRequest {

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String password;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateOfBirth;

    private BigInteger cardNumber;

    private BigInteger passportNumber;
}
