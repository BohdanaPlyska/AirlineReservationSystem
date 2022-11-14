package com.example.demo.mapper;

import com.example.demo.entity.PaymentEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.request.PaymentRequest;
import com.example.demo.response.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "paymentRequest.id", target = "id")
    @Mapping(source = "ticket", target = "ticket")
    @Mapping(source = "user", target = "user")
    PaymentEntity paymentRequestToPayment(PaymentRequest paymentRequest, UserEntity user, TicketEntity ticket);

    PaymentResponse paymentEntityToPaymentResponse(PaymentEntity paymentEntity);

    List<PaymentResponse> paymentEntityListToPaymentResponseList(List<PaymentEntity> paymentEntity);

}
