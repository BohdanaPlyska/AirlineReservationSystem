package com.example.demo.service;
import com.example.demo.entity.PaymentEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.PaymentMapper;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.PaymentRequest;
import com.example.demo.request.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final PaymentMapper paymentMapper;

    public PaymentResponse saveAndUpdate(PaymentRequest request) throws Exception{
        //find bi id user if not exception
        //the same for ticket
        //put user, ticket, and data from request to
        Optional<UserEntity> user =  userRepository.findById(request.getUserId());
        if(!user.isPresent()){
            throw  new Exception();
        }

        Optional<TicketEntity> ticket = ticketRepository.findById(request.getTicketId());
        if(!ticket.isPresent()) {
            throw new Exception();
        }

        PaymentEntity validDataForPayment = paymentMapper.paymentRequestToPayment(request, user.get(), ticket.get());
//        PaymentEntity validDataForPayment = paymentMapper.paymentRequestToPayment(request);

        PaymentEntity paymentEntity = paymentRepository.save(validDataForPayment);
        return paymentMapper.paymentEntityToPaymentResponse(paymentEntity);


    }

    public void delete(Long id){
        Optional<PaymentEntity> paymentEntityOptional = paymentRepository.findById(id);
        paymentEntityOptional.ifPresent(paymentRepository::delete);
    }

    public List<PaymentResponse> allPayments() {
        List<PaymentEntity> paymentEntities = paymentRepository.findAll();
        List<PaymentResponse> paymentResponses = paymentMapper.paymentEntityListToPaymentResponseList(paymentEntities);
       return paymentResponses;
    }

    public Optional<PaymentEntity> getPayment(Long id){
         return paymentRepository.findById(id);
    }

    public PaymentResponse findById(Long id){
        return paymentMapper.paymentEntityToPaymentResponse(paymentRepository.findById(id).get());
    }


}
