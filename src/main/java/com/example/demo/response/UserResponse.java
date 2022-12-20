package com.example.demo.response;

import lombok.Data;

@Data
public class UserResponse extends BaseResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

}
