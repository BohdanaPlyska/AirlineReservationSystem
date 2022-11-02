package com.example.demo.service;

import com.example.demo.entity.DiscountProgram;
import com.example.demo.entity.Ticket;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.mapper.DiscountProgramMapper;
import com.example.demo.repository.DiscountProgramRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.request.DiscountProgramRequest;
import com.example.demo.request.DiscountProgramResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountProgramService {

    private final DiscountProgramRepository discountRepository;
    private final DiscountProgramMapper discountMapper;
    private final TicketRepository ticketRepository;

    public DiscountProgramResponse save(DiscountProgramRequest discount) {

        Optional<Ticket>  ticket = ticketRepository.findById(discount.getTicketId());
        if(ticket.isEmpty()){
            throw new CustomFoundException("Ticket not found");
        }

        DiscountProgram validDataForPayment = discountMapper.discountProgramRequestToDiscountProgramEntity(discount, ticket.get());

        DiscountProgram discountProgram = discountRepository.save(validDataForPayment);
        return discountMapper.discountProgramEntityToDiscountProgramResponse(discountProgram);
    }

    public void delete(Long id) {
        Optional<DiscountProgram> discountProgram = discountRepository.findById(id);
        discountProgram.ifPresent(discountRepository::delete);
    }

    public DiscountProgramResponse findById(Long id) {
        return discountMapper.discountProgramEntityToDiscountProgramResponse(discountRepository.findById(id).get());
    }

    public Optional<DiscountProgram> getDiscount(Long id) {
        return discountRepository.findById(id);
    }

    public List<DiscountProgramResponse> allDiscounts() {
        return discountMapper.discountProgramEntityListToDiscountProgramResponseList(discountRepository.findAll());
    }

}
