package com.example.demo.service;
import com.example.demo.entity.PaymentEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.CustomAlreadyExistException;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.mapper.PaymentMapper;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.PaymentRequest;
import com.example.demo.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.constants.ValidationMessages.*;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final UserRepository userRepository;

    private final TicketRepository ticketRepository;

    private final PaymentMapper paymentMapper;

    public PaymentResponse save(PaymentRequest request) {
        findPaymentByTicket(request);
        Optional<TicketEntity> ticket = findTicketById(request);
        Optional<UserEntity> user = findUserById(request);
        PaymentEntity validDataForPaymentEntity = paymentMapper.paymentRequestToPayment(request, user.get(), ticket.get());
        PaymentEntity paymentEntity = paymentRepository.save(validDataForPaymentEntity);
        return paymentMapper.paymentEntityToPaymentResponse(paymentEntity);
    }

    public void delete(Long id){
        Optional<PaymentEntity> paymentEntityOptional = paymentRepository.findById(id);
        paymentEntityOptional.ifPresent(paymentRepository::delete);
    }

    public List<PaymentResponse> allPayments() {
        List<PaymentEntity> paymentEntityEntities = paymentRepository.findAll();
        return paymentMapper.paymentEntityListToPaymentResponseList(paymentEntityEntities);
    }

    public Optional<PaymentEntity> getPayment(Long id){
         return paymentRepository.findById(id);
    }

    public PaymentResponse findById(Long id){
        return paymentMapper.paymentEntityToPaymentResponse(Optional
                .ofNullable(
                        paymentRepository
                                .findById(id)
                                .orElseThrow(() -> new CustomFoundException(PAYMENT_NOT_FOUND))
                )
                .get()
        );
    }

    public Optional<PaymentEntity> findPaymentByTicket(PaymentRequest request) {
        Optional<PaymentEntity> paymentOptional = paymentRepository.findByTicketId(request.getTicket());
        if(paymentOptional.isPresent()){
            throw  new CustomAlreadyExistException(PAYMENT_ALREADY_EXIST);
        }
        return paymentOptional;
//        return Optional
//                .ofNullable(
//                        paymentRepository
//                                .findByTicketId(request.getTicket())
//                                .orElseThrow(() -> new CustomAlreadyExistException(PAYMENT_ALREADY_EXIST))
//                );
    }

    public Optional<TicketEntity> findTicketById(PaymentRequest request) {
        return Optional
                .ofNullable(ticketRepository
                        .findById(request.getTicket())
                        .orElseThrow(() -> new CustomFoundException(TICKET_NOT_FOUND))
                );
    }

    public Optional<UserEntity> findUserById(PaymentRequest request) {
        return Optional
                .ofNullable(userRepository
                        .findById(request.getUser())
                        .orElseThrow(() -> new CustomFoundException(USER_NOT_FOUND))
                );
    }

}
