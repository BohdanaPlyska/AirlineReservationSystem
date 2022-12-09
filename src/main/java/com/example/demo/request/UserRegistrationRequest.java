package com.example.demo.request;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;


import static com.example.demo.constants.RegexConstants.*;
import static com.example.demo.constants.ValidationMessages.NOT_BLANK;

@Data
@Valid
public class UserRegistrationRequest {

    private Long id;

    @Email
    @NotBlank(message = "this field can't be empty")
    private String email;

    @Size(min = 8, message = "at least 8 characters")
    @NotBlank(message = "this field can't be empty")
    private String password;

    @Size(min = 8, message = "at least 8 characters")
    @NotBlank(message = "this field can't be empty")
    private String passwordConfirm;

    @Column(name = "phoneNumber")
    @NotBlank
    @NotBlank(message = "this field can't be empty")
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_PHONE_NUMBER, message = " Should contain real phone number")
    private String phoneNumber;

    @NotBlank(message = NOT_BLANK)
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_NAME_AND_SURNAME,
            message = "firstName  should contains only characters and start uppercase character ")
    private String firstName;

    @NotBlank(message = "this field can't be empty")
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_NAME_AND_SURNAME,
            message = "lastName  should contains only characters and start uppercase character ")
    private String lastName;

}
