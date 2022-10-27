package com.example.demo.service;

import com.example.demo.entity.DiscountProgramEntity;
import com.example.demo.entity.TicketEntity;
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

    public DiscountProgramResponse saveAndUpdate(DiscountProgramRequest discount) {

        Optional<TicketEntity>  ticket = ticketRepository.findById(discount.getTicketId());
        if(!ticket.isPresent()){
            throw new RuntimeException();
        }

        DiscountProgramEntity validDataForPayment = discountMapper.discountProgramRequestToDiscountProgramEntity(discount, ticket.get());

        DiscountProgramEntity discountProgram = discountRepository.save(validDataForPayment);
        return discountMapper.discountProgramEntityToDiscountProgramResponse(discountProgram);
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

}
