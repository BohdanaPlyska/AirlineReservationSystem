package com.example.demo.mapper;

import com.example.demo.entity.Payment;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import com.example.demo.request.PaymentRequest;
import com.example.demo.request.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "paymentRequest.id", target = "id")
    @Mapping(source = "ticket", target = "ticket")
    @Mapping(source = "user", target = "user")
    Payment paymentRequestToPayment(PaymentRequest paymentRequest, User user, Ticket ticket);

    PaymentResponse paymentEntityToPaymentResponse(Payment paymentEntity);

    List<PaymentResponse> paymentEntityListToPaymentResponseList(List<Payment> paymentEntity);
}
