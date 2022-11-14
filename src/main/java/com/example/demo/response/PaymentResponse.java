package com.example.demo.response;

import lombok.Data;

@Data
public class PaymentResponse {

    private Boolean status;

    private String ownerName;

    private String ownerSurName;

    private Long finalPrice;

}
