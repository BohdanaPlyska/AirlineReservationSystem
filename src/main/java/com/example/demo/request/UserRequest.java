package com.example.demo.request;

import com.example.demo.entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

import static com.example.demo.constants.RegexConstants.*;
import static com.example.demo.constants.ValidationMessages.NOT_BLANK;
@Data
@Valid
//@FieldsValueMatch
public class UserRequest {

    private Long id;

    @NotBlank(message = NOT_BLANK)
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_NAME_AND_SURNAME,
             message = "firstName  should contains only characters and start uppercase character ")
    private String firstName;

    @NotBlank(message = "this field can't be empty")
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_NAME_AND_SURNAME,
            message = "lastName  should contains only characters and start uppercase character ")
    private String lastName;

    @NotBlank(message = "this field can't be empty")
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_NAME_AND_SURNAME,
            message = "userName  should contains only characters and start uppercase character ")
    private String userName;

    @Email
    @NotBlank(message = "this field can't be empty")
    private String email;

    @Size(min = 8, message = "at least 8 characters")
    @NotBlank(message = "this field can't be empty")
//    @FieldsValueMatch
    private String password;

    @Size(min = 8, message = "at least 8 characters")
    @NotBlank(message = "this field can't be empty")
    private String passwordConfirm;

    @Column(name = "phoneNumber")
    @NotBlank
    @NotBlank(message = "this field can't be empty")
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_PHONE_NUMBER, message = " Should contain real phone number")
    private String phoneNumber;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull
    @Past
    private Date dateOfBirth;

    @NotBlank(message = "this field can't be empty")
    @Pattern(regexp = VALIDATION_CONSTANT_TYPE_OF_PASSPORT_NUMBER,
            message = "the password must be the old pattern, the first 2 letters and 6 digits, or the new pattern, 9 digits ")
    private String passportNumber;

    private Boolean active;

    private Role role;

}
