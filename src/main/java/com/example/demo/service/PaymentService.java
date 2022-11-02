package com.example.demo.service;
import com.example.demo.entity.Payment;
import com.example.demo.entity.Ticket;
import com.example.demo.entity.User;
import com.example.demo.exception.CustomAlreadyExistException;
import com.example.demo.exception.CustomFoundException;
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

    public PaymentResponse save(PaymentRequest request) {

        Optional<Payment> paymentOptional = paymentRepository.findByUserAndTicket(request.getUser(), request.getTicket());
        if(!paymentOptional.isEmpty()){
            throw  new CustomAlreadyExistException("Payment already exist");
        }

        Optional<User> user =  userRepository.findById(request.getUser());
        if(user.isEmpty()){
            throw  new CustomFoundException("User not found with this id");
        }

        Optional<Ticket> ticket = ticketRepository.findById(request.getTicket());
        if(ticket.isEmpty()) {
            throw new CustomFoundException("Ticket not found with this id");
        }

        Payment validDataForPayment = paymentMapper.paymentRequestToPayment(request, user.get(), ticket.get());
        Payment paymentEntity = paymentRepository.save(validDataForPayment);
        return paymentMapper.paymentEntityToPaymentResponse(paymentEntity);
    }

    public void delete(Long id){
        Optional<Payment> paymentEntityOptional = paymentRepository.findById(id);
        paymentEntityOptional.ifPresent(paymentRepository::delete);
    }

    public List<PaymentResponse> allPayments() {
        List<Payment> paymentEntities = paymentRepository.findAll();
        return paymentMapper.paymentEntityListToPaymentResponseList(paymentEntities);
    }

    public Optional<Payment> getPayment(Long id){
         return paymentRepository.findById(id);
    }

    public PaymentResponse findById(Long id){
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isEmpty()){
            throw new CustomFoundException("Payment not found");
        }
        return paymentMapper.paymentEntityToPaymentResponse(paymentRepository.findById(id).get());
    }

}
