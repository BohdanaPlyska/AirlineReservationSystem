package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class UserRequest {

    @NotBlank(message = "this field can't be empty")
    private String firstName;

    @NotBlank(message = "this field can't be empty")
    private String lastName;

    @Email
    @NotBlank(message = "this field can't be empty")
    private String email;

    @Size(min = 8, message = "at least 8 characters")
    @NotBlank(message = "this field can't be empty")
    private String password;

    @Size(min = 8, message = "at least 8 characters, must match with password")
    @NotBlank(message = "this field can't be empty")
    private String passwordConfirm;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull
    @Past
    private Date dateOfBirth;

    @NotBlank(message = "this field can't be empty")
    private String passportNumber;
}
