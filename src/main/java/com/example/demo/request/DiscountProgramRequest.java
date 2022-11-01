package com.example.demo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DiscountProgramRequest {

    private Long id;

    @NotNull
    private Long ticketId;

}
