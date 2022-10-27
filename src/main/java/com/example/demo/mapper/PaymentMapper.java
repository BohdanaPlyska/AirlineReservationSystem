package com.example.demo.mapper;

import com.example.demo.entity.PaymentEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.request.PaymentRequest;
import com.example.demo.request.PaymentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "paymentRequest.id", target = "id")
    @Mapping(source = "ticket", target = "ticket")
    @Mapping(source = "user", target = "userId")
//    @Mapping(source = "user.id", target = "userId.id")
//    @Mapping(source = "ticket.id", target = "ticketId.id")
//    @Mapping(source = "ticket.price", target = "ticketId.price")
    PaymentEntity paymentRequestToPayment(PaymentRequest paymentRequest, UserEntity user, TicketEntity ticket);

//    PaymentEntity paymentRequestToPayment(PaymentRequest paymentRequest);


    PaymentResponse paymentEntityToPaymentResponse(PaymentEntity paymentEntity);

    List<PaymentResponse> paymentEntityListToPaymentResponseList(List<PaymentEntity> paymentEntity);
}
