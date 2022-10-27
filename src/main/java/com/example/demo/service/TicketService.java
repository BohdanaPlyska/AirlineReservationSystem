package com.example.demo.service;

import com.example.demo.entity.TicketEntity;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.repository.TicketRepository;
import com.example.demo.request.TicketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService{

    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;

    public TicketEntity buyTicket(TicketRequest ticketRequest) {
        //when user choose the ticket, fill info and choose discount =>
        // then we need to look on all active user tickets and update reservation time for all of them
        // request to db create reservation for ticket => we set reservation id to reservation table
        //calculate price which will be final including the discount
        //=> create payment and set all fields status, ticketId, finalPrice...
        //update ticket  status like sold/not available
        return null;
    }

    public List<TicketEntity> availableTickets() {
        //if in reservation id != null && experation time > (current time +...algorithm)
        // and in ticket have payment id not null it means sold ticket
        return null;
    }

    public TicketEntity saveAndUpdate(TicketRequest ticket) {
        return ticketRepository.save(ticketMapper.ticketRequestToTicket(ticket));
    }

    public void delete(Long id) {
        Optional<TicketEntity> ticket = ticketRepository.findById(id);
        ticket.ifPresent(ticketRepository::delete);
    }

    public List<TicketEntity> allTickets() {
        return ticketRepository.findAll();
    }

    public TicketEntity findById(Long id) {
        return ticketRepository.findById(id).get();
    }

    public Optional<TicketEntity> getTicket(Long id) {
        return ticketRepository.findById(id);
    }

    public TicketEntity addTicketToBasket(TicketEntity ticket) {
        return null;
    }
}
