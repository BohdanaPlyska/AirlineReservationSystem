package com.example.demo.request;

import lombok.Data;

@Data
public class PaymentResponse {
    private Long id;
    private Boolean status;
    private String ownerName;
    private String ownerSurName;
    private Long finalPrice;
}
