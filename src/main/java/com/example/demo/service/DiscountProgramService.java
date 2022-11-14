package com.example.demo.service;

import com.example.demo.entity.DiscountProgramEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.mapper.DiscountProgramMapper;
import com.example.demo.repository.DiscountProgramRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.request.DiscountProgramRequest;
import com.example.demo.response.DiscountProgramResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.constants.ValidationMessages.TICKET_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DiscountProgramService {

    private final DiscountProgramRepository discountRepository;
    private final DiscountProgramMapper discountMapper;
    private final TicketRepository ticketRepository;

    public DiscountProgramResponse save(DiscountProgramRequest discount) {
        Optional<TicketEntity>  ticket = findById(discount);
        DiscountProgramEntity validDataForPayment = discountMapper.discountProgramRequestToDiscountProgramEntity(discount, ticket.get());
        DiscountProgramEntity discountProgramEntity = discountRepository.save(validDataForPayment);
        return discountMapper.discountProgramEntityToDiscountProgramResponse(discountProgramEntity);
    }

    public void delete(Long id) {
        Optional<DiscountProgramEntity> discountProgram = discountRepository.findById(id);
        discountProgram.ifPresent(discountRepository::delete);
    }

    public DiscountProgramResponse findById(Long id) {
        return discountMapper.discountProgramEntityToDiscountProgramResponse(discountRepository.findById(id).get());
    }

    public Optional<DiscountProgramEntity> getDiscount(Long id) {
        return discountRepository.findById(id);
    }

    public List<DiscountProgramResponse> allDiscounts() {
        return discountMapper.discountProgramEntityListToDiscountProgramResponseList(discountRepository.findAll());
    }

    public  Optional<TicketEntity> findById(DiscountProgramRequest discount) {
        Optional<TicketEntity> ticket = ticketRepository.findById(discount.getTicket());
        if (ticket.isEmpty()) {
            throw new CustomFoundException(TICKET_NOT_FOUND);
        }
        return ticket;
    }

}
